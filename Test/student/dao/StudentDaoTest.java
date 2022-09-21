package student.dao;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import student.entity.Student;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

class StudentDaoTest {
    static StudentDao studentDao;
    static SqlSession sqlSession;

    @BeforeAll
    static void init() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        studentDao = sqlSession.getMapper(StudentDao.class);
    }

//    @AfterAll
//    static void close(){
//        if(sqlSession != null){
//            sqlSession.close();
//        }
//    }

    @org.junit.jupiter.api.Test
    void findOne(){
        List s = studentDao.findAll(2);
        System.out.println(s);
    }

    @Test
    void findAll(){
        List<Student> s = studentDao.findAll(null);
        for (int i=0; i< s.size();i++){
            System.out.println(s.get(i));
        }
    }
    @Test
    void update(){
        Student s = studentDao.findOne(3);
        s.setClass_id(2);
        studentDao.update(s);
        System.out.println(studentDao.findOne(3));
        sqlSession.commit();
    }
    @Test
    void delete(){
        studentDao.deleteOne(3);
        System.out.println(studentDao.findOne(3));
    }
    @Test
    void insert(){
        Student s = new Student();
        s.setId(4);
        s.setClass_id(2);
        s.setBirth(new Date());
        s.setSex("2");
        s.setSname("Josiane");
        s.setSno("2022001001");

        studentDao.insert(s);
        System.out.println(studentDao.findOne(4));
        sqlSession.commit();
    }
}