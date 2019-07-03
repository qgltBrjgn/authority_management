package com.qglt.test.controller;

import com.qglt.test.annotation.RequestPermission;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestAnnotationController {


    @RequestMapping("annotation")
    public String index(){
        return "annotation";
    }

    @RequestPermission(aclValue = "444")
    @RequestMapping("annotation01")
    @ResponseBody
    public String annotationMethod01(){
        return "你有annotation01的权限!!!";
    }

    @RequestPermission(aclValue = "555")
    @RequestMapping("annotation02")
    @ResponseBody
    public String annotationMethod02(){
        return "你有annotation02的权限!!!";
    }

    @RequestMapping("annotation03")
    @ResponseBody
    public String annotationMethod03(){
        return "你可以直接访问annotation03!!!因为没有设定权限码!!!";
    }

}
