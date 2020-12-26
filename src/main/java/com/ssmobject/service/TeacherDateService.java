package com.ssmobject.service;

import com.github.pagehelper.PageInfo;
import com.ssmobject.pojo.TeacherClassDate;
import com.ssmobject.pojo.TeacherCourseDate;
import com.ssmobject.pojo.TeacherScoreDate;
import com.ssmobject.pojo.TeacherStudentDate;

public interface TeacherDateService {
    PageInfo<TeacherStudentDate> TeacherSearchStudent(String id, int page, int limit);

    PageInfo<TeacherStudentDate> TeacherGetStudentList(int page, int limit);

    int deleteUser(String scoreid,String scoresname,String scorecname);

    int insertUser(TeacherScoreDate scoreDate);

    int updateUser(TeacherScoreDate scoreDate);

    PageInfo<TeacherCourseDate> TeacherGetCourseList(int page, int limit);

    PageInfo<TeacherClassDate> TeacherGetClassList(int page, int limit);
}
