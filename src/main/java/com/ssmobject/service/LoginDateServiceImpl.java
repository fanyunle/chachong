package com.ssmobject.service;

import com.ssmobject.mapper.LoginMapper;
import com.ssmobject.pojo.LoginDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginDateServiceImpl implements LoginDateService{
    @Autowired
    private LoginMapper loginMapper;

    public LoginDate Login(String username) {
        LoginDate loginDate=loginMapper.getLoginDate(username);

        return loginDate;
    }
}
