package com.example.demo.po;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "stu_classes", schema = "stusystem", catalog = "")
public class StuClasses {
    private int clsId;
    private String clsName;
    private String clsTeacher;

    @Id
    @Column(name = "cls_id")
    @GeneratedValue
    public int getClsId() {
        return clsId;
    }

    public void setClsId(int clsId) {
        this.clsId = clsId;
    }

    @Basic
    @Column(name = "cls_name")
    public String getClsName() {
        return clsName;
    }

    public void setClsName(String clsName) {
        this.clsName = clsName;
    }

    @Basic
    @Column(name = "cls_teacher")
    public String getClsTeacher() {
        return clsTeacher;
    }

    public void setClsTeacher(String clsTeacher) {
        this.clsTeacher = clsTeacher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StuClasses that = (StuClasses) o;
        return clsId == that.clsId &&
                Objects.equals(clsName, that.clsName) &&
                Objects.equals(clsTeacher, that.clsTeacher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clsId, clsName, clsTeacher);
    }
}
