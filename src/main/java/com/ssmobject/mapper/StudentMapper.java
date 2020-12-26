package com.ssmobject.mapper;

import com.ssmobject.pojo.StudentClassDate;
import com.ssmobject.pojo.StudentCourseDate;
import com.ssmobject.pojo.StudentTableDate;

import java.util.List;

public interface StudentMapper {
    List<StudentCourseDate> StudentGetCourse();//查询课程信息

    List<StudentTableDate> StudentTableDate(String id);//查询个人信息

    List<StudentClassDate> StudentGetClassDate();//查询班级成绩信息
}
