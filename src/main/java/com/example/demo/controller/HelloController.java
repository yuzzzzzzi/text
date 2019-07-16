package com.example.demo.controller;

import com.example.demo.dao.StudentDao;
import com.example.demo.po.StuStudent;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

/**
 * @Author: yuzi
 * @Data: 2019/7/15
 */
@RestController
public class HelloController {
    @Autowired
    private StudentDao dao;

    @GetMapping("/hello")
    public String hello() {
        return "hello world";
    }


    @GetMapping("/gettime")
    public Timestamp gettime(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return timestamp;
    }

    @GetMapping("/insert")
    public String insert() {
        StuStudent stuStudent = new StuStudent();
        stuStudent.setStuName("狗头");
        stuStudent.setStuNum("0006");
        stuStudent.setStuSex("1");
        stuStudent.setStuBirthday(new Timestamp(System.currentTimeMillis()));

        dao.save(stuStudent);

        return "ok";
    }


    @GetMapping("/info/{id}")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "int", paramType = "path")
    public StuStudent getStudent(@PathVariable int id){
        StuStudent stuStudent = dao.findById(id).get();
        return stuStudent;
    }


}
