package com.qglt.test.controller;

import com.qglt.test.po.User;
import com.qglt.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by qingt on 2019/6/26.
 */
@Controller
@RequestMapping("intercept")
public class TestInterceptorController {

    @Autowired
    private UserService userService;

    @RequestMapping("test")
    @ResponseBody
    public String index(){
        return "hello!!!";
    }

    @RequestMapping("queryUserById")
    @ResponseBody
    public User queryUser(Integer userId){
        return userService.queryUserById(userId);
    }
}
