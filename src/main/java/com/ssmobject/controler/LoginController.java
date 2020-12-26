package com.ssmobject.controler;

import com.ssmobject.bean.LoginUser;
import com.ssmobject.pojo.LoginDate;
import com.ssmobject.service.LoginDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private LoginDateService loginDateService;


    @RequestMapping(value = "login",method = RequestMethod.POST)
    public LoginUser Login(String username,String password,int success){
        LoginUser loginUser=new LoginUser();
        LoginDate loginDate;
        String pwd="";
        loginDate=loginDateService.Login(username);
        try{
            pwd=loginDate.getPassword();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("用户名不存在");
            loginUser.setSuccess(3);
            return loginUser;
        }
        if(pwd.equals(password)){
            loginUser.setSuccess(1);
            loginUser.setUsername(username);
            loginUser.setType(loginDate.getType());
            loginUser.setName(loginDate.getName());
        }else{
            loginUser.setSuccess(0);
            System.out.println("密码错误");
        }
        return loginUser;
    }
}
