package student.dao;

import student.entity.Student;

import java.util.List;

public interface StudentDao {

    Student findOne(Integer id);
    List<Student> findAll(Integer id);
    void update(Student s);
    void deleteOne(Integer id);
    void insert(Student s);
}
