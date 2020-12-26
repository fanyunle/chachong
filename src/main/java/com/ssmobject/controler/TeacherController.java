package com.ssmobject.controler;

import com.github.pagehelper.PageInfo;
import com.ssmobject.bean.TableData;
import com.ssmobject.bean.ajaxDelete;
import com.ssmobject.bean.ajaxUpdate;
import com.ssmobject.pojo.TeacherClassDate;
import com.ssmobject.pojo.TeacherCourseDate;
import com.ssmobject.pojo.TeacherScoreDate;
import com.ssmobject.pojo.TeacherStudentDate;
import com.ssmobject.service.TeacherDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherDateService dateService;

    private TableData tableData;

    PageInfo<TeacherStudentDate> pageInfo;

    @RequestMapping("/userlist")
    public TableData TeacherGetStudentTable(int page, int limit, String key){
        pageInfo=new PageInfo<TeacherStudentDate>();
        if(key==null||key==""){
            //如果key为空，则查所有
            pageInfo = dateService.TeacherGetStudentList(page,limit);
        }else {
            //不为空，则进行搜索
            pageInfo = dateService.TeacherSearchStudent(key,page,limit);
        }
        tableData = new TableData();
        tableData.setCode(0);
        tableData.setMsg("成功");
        tableData.setCount(pageInfo.getTotal());//设置总条数
        tableData.setData(pageInfo.getList());//设置当前数据
        return tableData;
    }

    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public ajaxDelete getUser(HttpServletRequest req){
        ajaxDelete del=new ajaxDelete();
        int a=dateService.deleteUser(req.getParameter("sid"),req.getParameter("sname"),req.getParameter("scorecname"));
        del.setCode(a);
        return del;
    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public ajaxUpdate updateUser(HttpServletRequest req){
        ajaxUpdate update=new ajaxUpdate();
        TeacherScoreDate scoreDate=new TeacherScoreDate();

        scoreDate.setScoreid(req.getParameter("scoreid"));
        scoreDate.setScoresname(req.getParameter("scoresname"));
        scoreDate.setScorecname(req.getParameter("scorecname"));
        scoreDate.setScoreu(req.getParameter("scoreu"));
        scoreDate.setScoref(req.getParameter("scoref"));
        scoreDate.setScoregrade(req.getParameter("scoregrade"));

        System.out.println(req.getParameter("scoresname")+req.getParameter("scoreid")+req.getParameter("scorecname"));
        int a=dateService.updateUser(scoreDate);
        update.setCode(a);
        return update;
    }

    @RequestMapping(value = "insert",method = RequestMethod.POST)
    public ajaxUpdate insertUser(HttpServletRequest req){
        ajaxUpdate insert=new ajaxUpdate();
        TeacherScoreDate scoreDate=new TeacherScoreDate();

        scoreDate.setScoreid(req.getParameter("scoreid"));
        scoreDate.setScoresname(req.getParameter("scoresname"));
        scoreDate.setScorecname(req.getParameter("scorecname"));
        scoreDate.setScoreu(req.getParameter("scoreu"));
        scoreDate.setScoref(req.getParameter("scoref"));
        scoreDate.setScoregrade(req.getParameter("scoregrade"));


        int a=dateService.insertUser(scoreDate);
        insert.setCode(a);
        return insert;
    }

    @RequestMapping("/course")
    public TableData TeacherGetCourse(int page, int limit){
        PageInfo<TeacherCourseDate> pageInfo=dateService.TeacherGetCourseList(page,limit);
        tableData = new TableData();
        tableData.setCode(0);
        tableData.setMsg("成功");
        tableData.setCount(pageInfo.getTotal());//设置总条数
        tableData.setData(pageInfo.getList());//设置当前数据
        return tableData;
    }

    @RequestMapping("/class")
    public TableData TeacherGetClass(int page, int limit){
        PageInfo<TeacherClassDate> pageInfo=dateService.TeacherGetClassList(page,limit);
        tableData = new TableData();
        tableData.setCode(0);
        tableData.setMsg("成功");
        tableData.setCount(pageInfo.getTotal());//设置总条数
        tableData.setData(pageInfo.getList());//设置当前数据
        return tableData;
    }
}
