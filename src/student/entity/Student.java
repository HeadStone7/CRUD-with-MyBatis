package student.entity;

import java.util.Date;

public class Student {
    private Integer id;
    private String Sno;
    private String Sname;
    private String Sex;
    private Date Birth;
    private Integer Class_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSno() {
        return Sno;
    }

    public void setSno(String sno) {
        Sno = sno;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public Date getBirth() {
        return Birth;
    }

    public void setBirth(Date birth) {
        Birth = birth;
    }

    public Integer getClass_id() {
        return Class_id;
    }

    public void setClass_id(Integer class_id) {
        Class_id = class_id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", Sno='" + Sno + '\'' +
                ", Sname='" + Sname + '\'' +
                ", Sex='" + Sex + '\'' +
                ", Birth=" + Birth +
                ", Class_id=" + Class_id +
                '}';
    }
}
