package com.ssmobject.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssmobject.mapper.StudentMapper;
import com.ssmobject.pojo.StudentClassDate;
import com.ssmobject.pojo.StudentCourseDate;
import com.ssmobject.pojo.StudentTableDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentDateServiceImpl implements StudentDateService{

    @Autowired
    private StudentMapper studentMapper;

    public PageInfo<StudentCourseDate> StudentGetCourseList(int page, int limit) {
        PageHelper.startPage(page,limit);
        List<StudentCourseDate> courseDates=studentMapper.StudentGetCourse();
        PageInfo<StudentCourseDate> pageInfo=new PageInfo<StudentCourseDate>(courseDates);
        return pageInfo;
    }

    public PageInfo<StudentTableDate> StudentGetTableList(int page, int limit, String id) {
        PageHelper.startPage(page,limit);
        List<StudentTableDate> tableDates=studentMapper.StudentTableDate(id);
        PageInfo<StudentTableDate> pageInfo=new PageInfo<StudentTableDate>(tableDates);
        return pageInfo;
    }

    public PageInfo<StudentClassDate> StudentGetClassList(int page, int limit) {
        PageHelper.startPage(page,limit);
        List<StudentClassDate> classDates=studentMapper.StudentGetClassDate();
        PageInfo<StudentClassDate> pageInfo=new PageInfo<StudentClassDate>(classDates);
        return pageInfo;
    }
}
