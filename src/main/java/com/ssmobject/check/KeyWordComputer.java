package com.ssmobject.check;


import org.ansj.app.keyword.Keyword;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.NlpAnalysis;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.xmlbeans.XmlException;

import java.io.*;
import java.util.*;

public class KeyWordComputer {
    private static final Map<String, Double> POS_SCORE = new HashMap<String, Double>();
    private int Keyword = 20;
    //依据词性进行分词结果的过滤
    static {

        //https://blog.csdn.net/woshixiaoxiamidiyi/article/details/52246020
        POS_SCORE.put("null", 0.0);
        POS_SCORE.put("w", 0.0);
        POS_SCORE.put("en", 1.0);
        POS_SCORE.put("m", 0.0);
        POS_SCORE.put("num", 0.0);
        POS_SCORE.put("nr", 3.0);
        POS_SCORE.put("nrf", 3.0);
        POS_SCORE.put("nw", 3.0);
        POS_SCORE.put("nl", 3.0);
        POS_SCORE.put("n", 3.0);
        POS_SCORE.put("ns", 3.0);
        POS_SCORE.put("nt", 3.0);
        POS_SCORE.put("l", 0.2);
        POS_SCORE.put("a", 0.2);
        POS_SCORE.put("nz", 3.0);
        POS_SCORE.put("v", 0.2);
        POS_SCORE.put("kw", 6.0);//关键词词性
    }    //预设关键词个数为20。

    public  Map<String,Integer> Test(String filename) throws IOException, OpenXML4JException, XmlException {
        String fileName =  filename;
        FileInputStream sampleFile = new FileInputStream(fileName);
        String text = "";
        String title = "";
        String str;
        if(fileName.endsWith(".txt")){
            InputStreamReader isr = new InputStreamReader(sampleFile, "GBK");
            int flag=0;
            BufferedReader buread = new BufferedReader(isr);
            while ((str= buread.readLine()) != null) {
                if (flag==0){
                    title = str;
                    str=buread.readLine();
                }
                text = text + str;
                flag = 1;
            }
            buread.close();
        }else if (fileName.endsWith(".doc")){
            InputStream is = new FileInputStream(new File(fileName));
            WordExtractor ex = new WordExtractor(is);
            str = ex.getText();
            //System.out.println(str);
            String [] arry = str.split("\\r\\n");
            int flag = 0;
            for (String string : arry) {
                if(flag==0){
                    title = arry[0];
                }else{
                    text = text + string;
                }
                flag = 1;
            }
            ex.close();
        }else{
            OPCPackage opcPackage = POIXMLDocument.openPackage(fileName);
            POIXMLTextExtractor extractor = new XWPFWordExtractor(opcPackage);
            str = extractor.getText();
            String [] arry = str.split("\\r\\n");
            int flag = 0;
            for (String string : arry) {
                if(flag==0){
                    title = arry[0];
                }else{
                    text = text + string;
                }
                flag = 1;
            }
            extractor.close();
        }
        //\t 跳格   \r 回车    \n 换行  \\ 反斜杠   \a 警告   \b 退格    \f 换页
        //正则匹配去除文本中的标点符号
        text = text.replaceAll("[\\pP+~$`^=|<>～｀＄＾＋＝｜＜＞￥×]", "");
        //获得最终关键词
        List<Keyword> list = computeArticleTfidf(title,text);
        //把关键词转换成String类型
        List<String> resultlist = new ArrayList<String>();
        //split的工作原理是利用正则表达式,而在正则则表达式中, "."有特殊意思,所以匹配"."时要用转义字符"\",
        // 所以在正则表达式中匹配"."的表达式是"\.", 而在Java中,\又是特殊字符, 所以还要进行转义, 所以最终变成"\\."

        //"\\d"，\ 转义字符 加\d 是一zhi个正字表达式，标识所有dao数zhuan字及0-9
        for (Object o : list){
            resultlist.add(String.valueOf(o).replaceAll("/" , "").replaceAll("\\d" , "").replaceAll("\\." , ""));
        }
        //获取关键词在文章中出现的次数并保存到map中
        Map<String,Integer> map = new HashMap<String,Integer>();
        for (String string:resultlist){
            String content =title + text;
            int count = 0;
            // 调用String类的indexOf(String str)方法，返回第一个相同字符串出现的下标
            while (content.indexOf(string) != -1) {
                // 如果存在相同字符串则次数加1
                count++;
                // 调用String类的substring(int beginIndex)方法，获得第一个相同字符出现后的字符串
                content = content.substring(content.indexOf(string) + string.length());
            }
            map.put(string,count);
        }
        return map;
    }
    // 判断title与content是否为空值，如果不是空值，title后面加制表符加content，组成新的字符串，传回新的参数(title +"\t" +content, title.length());
    public List<Keyword> computeArticleTfidf(String title, String content) {
        if (title.isEmpty()) {
            title = "";
        }
        if (content.isEmpty()) {
            content = "";
        }
        return computeArticleTfidf(title + "\t" + content, title.length());
    }
    //分词
    private List<Keyword> computeArticleTfidf(String content, int titleLength) {
        Map<String, Keyword> tm = new HashMap<String, Keyword>();
        //分词 用nlp分词
        List<Term> parse = NlpAnalysis.parse(content).getTerms();
        //System.out.println("~~~~~~~~~~~~~~"+parse);
        //FIXME:这个依赖于用户自定义词典的词性,所以得需要另一个方法..
        //parse = FilterModifWord.updateNature(parse) ;
        //遍历获取权重比，根据不同权重比获取前20个权重比大的关键词
        // term.getName()获取词
        //term.getNatureStr()获取词性 --en

        for (Term term : parse) {
            double weight = getWeight(term, content.length(),titleLength);
            if (weight == 0){
                //System.out.println("2"+term.getName()+":"+term.getNatureStr());
                continue;
            }
            Keyword keyword = tm.get(term.getName());
            if (keyword ==null) {
                //System.out.println("1"+term.getName()+":"+term.getNatureStr());
                keyword = new Keyword(term.getName(),term.natrue().allFrequency,weight);
                tm.put(term.getName(),keyword);
            } else {
                //System.out.println("2"+term.getName()+":"+term.getNatureStr());
                keyword.updateWeight(1);
            }
        }
        TreeSet<Keyword> treeSet = new TreeSet<Keyword>(tm.values());
        ArrayList<Keyword> arrayList = new ArrayList<Keyword>(treeSet);
        if (treeSet.size() <= Keyword) {
            return arrayList;
        } else {
            int i= 0;
            for(Object o:arrayList.subList(0,Keyword)){
                System.out.println(i+":"+o.toString().replaceAll("/" , "").replaceAll("\\d" , "").replaceAll("\\." , ""));
                i++;
            }
            return arrayList.subList(0,Keyword);
        }

    }
    //获取所有词的权重比
    private double getWeight(Term term, int length, int titleLength) {
        if (term.getName().trim().length() < 2) {
            return 0;
        }
        String pos = term.natrue().natureStr;
        //System.out.println("~~~~~~~~"+pos);
        Double posScore = POS_SCORE.get(pos);
        if (posScore == null) {
            posScore = 1.0;
        } else if (posScore == 0) {
            return 0;
        }
        if (titleLength >term.getOffe()) {
            return 5 * posScore;
        }
        return (length -term.getOffe()) *posScore / (double) length;
    }
}
