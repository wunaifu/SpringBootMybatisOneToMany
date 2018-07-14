package com.wnf;

import com.wnf.dao.*;
import com.wnf.entity.*;
import com.wnf.service.TutorService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    IPersonDao iPersonDao;
    @Autowired
    IProvincesDao iProvincesDao;
    @Autowired
    IUserDao iUserDao;
    @Autowired
    ICityDao iCityDao;
    @Autowired
    TutorDao tutorDao;

    @Autowired
    TutorService tutorService;

    @Test
    public void contextLoads() {

        List<Citys> citysList = iCityDao.getCitybypid(1);
        if (citysList!=null&&citysList.size()>0) {
            for (Citys citys : citysList) {
                System.out.println(citys.getCname());
            }
        }

    }

    @Test   //注解实现一对一
    public void Testonttoone() throws IOException {

        // 根据id查询Person对象，同时需要获得关联的Card对象
        Person person=iPersonDao.getPerson(4);
        System.out.println(person);
        System.out.println(person.getCard().getCnumber());
    }

    @Test   //注解实现一对多
    public void Testonttomany() throws IOException {

        Provinces provinces=iProvincesDao.getProvincesByid(1);
        System.out.println(provinces.getPname());
        System.out.println(provinces.getCitysSet());

        if (provinces.getCitysSet()!=null&&provinces.getCitysSet().size()>0) {
            for (Citys citys : provinces.getCitysSet()) {
                System.out.println(citys.getCname());
            }
        }

    }

    @Test   //注解实现多对多
    public void Testmanytomany() throws IOException {

        Users users=iUserDao.getUsersById(1);
        System.out.println(users.getUname());

        for (Roles roles : users.getRoles()) {
            System.out.println(roles.getRname());
        }

    }

    @Test   //resultMap实现一对多
    public void Testmanytomany2() throws IOException {

//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config"));
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//
//        IUserDao iUserDao=sqlSession.getMapper(IUserDao.class);
        Tutor tutor=tutorDao.findTutorById(1);
        System.out.println(tutor.getName());
        for (Course course : tutor.getCourses()) {
            System.out.println("    "+course.getCname());
        }

//        sqlSession.close();

    }

    @Test
    public void te() throws IOException {

        Users users = new Users();
        users.setUname("名字");
        tutorService.addUser(users);

    }

}
