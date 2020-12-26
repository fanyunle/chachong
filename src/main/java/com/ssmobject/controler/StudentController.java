package com.ssmobject.controler;

import com.github.pagehelper.PageInfo;
import com.ssmobject.bean.TableData;
import com.ssmobject.pojo.StudentClassDate;
import com.ssmobject.pojo.StudentCourseDate;
import com.ssmobject.pojo.StudentTableDate;
import com.ssmobject.service.StudentDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentDateService dateService;

    PageInfo<StudentTableDate> pageInfo;
    private TableData tableData;

    @RequestMapping("/userlist")
    public TableData StudentGetUserList(int page,int limit ,String key){
        pageInfo=new PageInfo<StudentTableDate>();
        pageInfo=dateService.StudentGetTableList(page,limit,key);
        tableData = new TableData();
        tableData.setCode(0);
        tableData.setMsg("成功");
        tableData.setCount(pageInfo.getTotal());//设置总条数
        tableData.setData(pageInfo.getList());//设置当前数据
        return tableData;
    }

    @RequestMapping("/course")
    public TableData StudentGetCourse(int page, int limit){
        PageInfo<StudentCourseDate> pageInfo=dateService.StudentGetCourseList(page,limit);
        tableData = new TableData();
        tableData.setCode(0);
        tableData.setMsg("成功");
        tableData.setCount(pageInfo.getTotal());//设置总条数
        tableData.setData(pageInfo.getList());//设置当前数据
        return tableData;
    }

    @RequestMapping("/class")
    public TableData StudentGetClass(int page, int limit){
        PageInfo<StudentClassDate> pageInfo=dateService.StudentGetClassList(page,limit);
        tableData = new TableData();
        tableData.setCode(0);
        tableData.setMsg("成功");
        tableData.setCount(pageInfo.getTotal());//设置总条数
        tableData.setData(pageInfo.getList());//设置当前数据
        return tableData;
    }
}
