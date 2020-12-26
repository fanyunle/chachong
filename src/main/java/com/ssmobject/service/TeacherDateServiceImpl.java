package com.ssmobject.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssmobject.mapper.TeacherMapper;
import com.ssmobject.pojo.TeacherClassDate;
import com.ssmobject.pojo.TeacherCourseDate;
import com.ssmobject.pojo.TeacherScoreDate;
import com.ssmobject.pojo.TeacherStudentDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherDateServiceImpl implements TeacherDateService{
    @Autowired
    private TeacherMapper teacherMapper;

    public PageInfo<TeacherStudentDate> TeacherGetStudentList(int page, int limit) {
        PageHelper.startPage(page,limit);
        List<TeacherStudentDate> studentDateList=teacherMapper.TeacherGetStudentUserDate();
        PageInfo<TeacherStudentDate> pageInfo=new PageInfo<TeacherStudentDate>(studentDateList);
        return pageInfo;
    }

    public PageInfo<TeacherStudentDate> TeacherSearchStudent(String id, int page, int limit) {
        PageHelper.startPage(page,limit);
        List<TeacherStudentDate> userList=teacherMapper.TeacherGetKeyStudent(id);
        PageInfo<TeacherStudentDate> pageInfo=new PageInfo<TeacherStudentDate>(userList);
        return pageInfo;
    }

    public int deleteUser(String scoreid,String scoresname,String scorecname) {
        TeacherScoreDate scoreDate=new TeacherScoreDate();
        scoreDate.setScoreid(scoreid);
        scoreDate.setScoresname(scoresname);
        scoreDate.setScorecname(scorecname);
        int a=teacherMapper.ajaxDelete(scoreDate);
        return a;
    }

    public int insertUser(TeacherScoreDate scoreDate) {
        int a=teacherMapper.ajaxInsert(scoreDate);
        return a;
    }

    public int updateUser(TeacherScoreDate scoreDate) {
        int a=teacherMapper.ajaxUpdate(scoreDate);
        return a;
    }

    public PageInfo<TeacherCourseDate> TeacherGetCourseList(int page, int limit) {
        PageHelper.startPage(page,limit);
        List<TeacherCourseDate> courseDates=teacherMapper.TeacherGetCourseDate();
        PageInfo<TeacherCourseDate> pageInfo=new PageInfo<TeacherCourseDate>(courseDates);
        return pageInfo;
    }

    public PageInfo<TeacherClassDate> TeacherGetClassList(int page, int limit) {
        PageHelper.startPage(page,limit);
        List<TeacherClassDate> classDates=teacherMapper.TeacherGetClassDate();
        PageInfo<TeacherClassDate> pageInfo=new PageInfo<TeacherClassDate>(classDates);
        return pageInfo;
    }
}
