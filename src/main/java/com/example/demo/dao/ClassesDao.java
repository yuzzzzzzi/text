package com.example.demo.dao;

import com.example.demo.po.StuClasses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassesDao  extends JpaRepository<StuClasses, Integer> {

}
