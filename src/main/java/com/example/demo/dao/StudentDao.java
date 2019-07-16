package com.example.demo.dao;

import com.example.demo.po.StuStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

/**
 * @Author: joy
 * @Date: 2019/7/15 14:41
 */
public interface StudentDao extends JpaRepository<StuStudent, Integer>  {

    @Modifying
    @Query(value = "select * from stu_student where stu_name like ?",nativeQuery = true)
    List<StuStudent> studentLike(String key);

    @Modifying
    @Query(value = "select * from stu_student ss LEFT join stu_classes sc ON ss.stu_class_id = sc.cls_id",nativeQuery = true)
    List<Map<String,Object>> stuAllWithClass();
}

