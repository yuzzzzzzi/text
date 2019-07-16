package com.example.demo.po;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @Author: joy
 * @Date: 2019/7/15 14:30
 */
@Entity
@Table(name = "stu_student", schema = "stusystem", catalog = "")
public class StuStudent extends StuClasses {
    private int stuId;
    private String stuNum;
    private String stuName;
    private String stuSex;
    private Timestamp stuBirthday;
    private Integer stuClassId;

    @Id
    @Column(name = "stu_id", nullable = false)
    @GeneratedValue
    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    @Basic
    @Column(name = "stu_num", nullable = true, length = 50)
    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    @Basic
    @Column(name = "stu_name", nullable = true, length = 50)
    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    @Basic
    @Column(name = "stu_sex", nullable = true, length = 1)
    public String getStuSex() {
        return stuSex;
    }

    public void setStuSex(String stuSex) {
        this.stuSex = stuSex;
    }

    @Basic
    @Column(name = "stu_birthday", nullable = true)
    public Timestamp getStuBirthday() {
        return stuBirthday;
    }

    public void setStuBirthday(Timestamp stuBirthday) {
        this.stuBirthday = stuBirthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StuStudent that = (StuStudent) o;
        return stuId == that.stuId &&
                Objects.equals(stuNum, that.stuNum) &&
                Objects.equals(stuName, that.stuName) &&
                Objects.equals(stuSex, that.stuSex) &&
                Objects.equals(stuBirthday, that.stuBirthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stuId, stuNum, stuName, stuSex, stuBirthday);
    }

    @Basic
    @Column(name = "stu_class_id")
    public Integer getStuClassId() {
        return stuClassId;
    }

    public void setStuClassId(Integer stuClassId) {
        this.stuClassId = stuClassId;
    }
}
