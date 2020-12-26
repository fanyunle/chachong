package com.ssmobject.service;

import com.github.pagehelper.PageInfo;
import com.ssmobject.pojo.StudentClassDate;
import com.ssmobject.pojo.StudentCourseDate;
import com.ssmobject.pojo.StudentTableDate;

public interface StudentDateService {
    PageInfo<StudentCourseDate> StudentGetCourseList(int page, int limit);

    PageInfo<StudentTableDate> StudentGetTableList(int page,int limit,String id);

    PageInfo<StudentClassDate> StudentGetClassList(int page, int limit);
}
