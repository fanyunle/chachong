package com.ssmobject.mapper;

import com.ssmobject.pojo.TeacherClassDate;
import com.ssmobject.pojo.TeacherCourseDate;
import com.ssmobject.pojo.TeacherScoreDate;
import com.ssmobject.pojo.TeacherStudentDate;

import java.util.List;

public interface TeacherMapper {
    List<TeacherStudentDate> TeacherGetStudentUserDate();//查询学生信息
    List<TeacherStudentDate> TeacherGetKeyStudent(String id);//查询单个
    int ajaxDelete(TeacherScoreDate studentDate);//删除指定
    int ajaxInsert(TeacherScoreDate scoreDate);//插入信息
    int ajaxUpdate(TeacherScoreDate scoreDate);//编辑指定

    List<TeacherCourseDate> TeacherGetCourseDate();//查询课程信息

    List<TeacherClassDate> TeacherGetClassDate();//查询班级成绩信息
}
