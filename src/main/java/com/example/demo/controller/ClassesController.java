package com.example.demo.controller;

import com.example.demo.dao.ClassesDao;
import com.example.demo.po.StuClasses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.List;

@RestController
@RequestMapping("/cls")
public class ClassesController {

    @Autowired
    private ClassesDao dao;

    /**
     * 1、查
     * @param id
     */
    @GetMapping("get/{id}")
    public StuClasses getById(@PathVariable Integer id) {
        StuClasses stuClasses = dao.findById(id).get();
        return stuClasses;
    }

    /**
     * 2、增
     * @param
     */
    @PostMapping("insert")
    public StuClasses insert(@RequestBody StuClasses stuClass) {
        dao.save(stuClass);
        return stuClass;
    }

    /**
     * 3、删
     * @param id
     */
    @DeleteMapping("delete/{id}")
    public StuClasses deleteById(@Valid @PathVariable Integer id) {
        StuClasses stuClass = dao.findById(id).get();
        dao.delete(stuClass);
        return stuClass;
    }

    /**
     * 4、改
     * @param
     */
    @PutMapping("update")
    public StuClasses update(@RequestBody LinkedHashMap<String,String> params) {
        StuClasses stuClass = dao.findById(Integer.parseInt(params.get("cls_id"))).get();
        stuClass.setClsName(params.get("stu_num"));
        stuClass.setClsTeacher(params.get("stu_name"));
        dao.save(stuClass);
        return stuClass;
    }

    /**
     * 5、全
     */
    @GetMapping("all")
    public List<StuClasses> getAll() {
        return dao.findAll();
    }

}
