package com.example.demo.controller;

import com.example.demo.dao.StudentDao;
import com.example.demo.po.StuStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: yuzi
 * @Data: 2019/7/15
 */

@RestController
@RequestMapping("stu/")
public class StudentController {
    @Autowired
    private StudentDao dao;
    /**
     * 1、查
     * @param id
     */
    @GetMapping("get/{id}")
    public StuStudent getById(@PathVariable Integer id) {
        StuStudent stuStudent = dao.findById(id).get();
        return stuStudent;
    }

    /**
     * 2、增
     * @param
     */
    @PostMapping("insert")
    public StuStudent insert(@RequestBody StuStudent student) {
        dao.save(student);
        return student;
    }

    /**
     * 3、删
     * @param id
     */
    @DeleteMapping("delete/{id}")
    public StuStudent deleteById(@Valid @PathVariable Integer id) {
        StuStudent student = dao.findById(id).get();
        dao.delete(student);
        return student;
    }

    /**
     * 4、改
     * @param
     */
    @PutMapping("update")
    public StuStudent update(@RequestBody LinkedHashMap<String,String> params) {
        StuStudent student = dao.findById(Integer.parseInt(params.get("stu_id"))).get();
        student.setStuNum(params.get("stu_num"));
        student.setStuName(params.get("stu_name"));
        student.setStuSex(params.get("stu_sex"));
        student.setStuBirthday(Timestamp.valueOf(params.get("stu_birthday")));
        dao.save(student);
        return student;
    }

    /**
     * 5、全
     */
    @GetMapping("all")
    public List<StuStudent> getAll() {
        return dao.findAll();
    }

    /**
     * 6、模糊搜索
     */
    @GetMapping("search")
    public List<StuStudent> getLike(String key) {
        System.out.println(key);
        key = "%"+key+"%";
        return dao.studentLike(key);
    }
    /**
     * 7、获取全部的学生与班级
     */
    @GetMapping("allwithclass")
    public List<Map<String, Object>> getAllWithClass() {
        return dao.stuAllWithClass();
    }

}
