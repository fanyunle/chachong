package com.ssmobject.mapper;

import com.ssmobject.pojo.LoginDate;

import java.util.List;

public interface LoginMapper {
    LoginDate getLoginDate(String username);
}
