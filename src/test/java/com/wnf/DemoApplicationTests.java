package com.wnf;

import com.wnf.dao.IPersonDao;
import com.wnf.dao.IProvincesDao;
import com.wnf.dao.IUserDao;
import com.wnf.entity.*;
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

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    IPersonDao iPersonDao;
    @Autowired
    IProvincesDao iProvincesDao;
    @Autowired
    IUserDao iUserDao;

    @Test
    public void contextLoads() {
    }

    @Test   //一对一
    public void Testonttoone() throws IOException {

        // 根据id查询Person对象，同时需要获得关联的Card对象
        Person person=iPersonDao.getPerson(4);
        System.out.println(person);
        System.out.println(person.getCard().getCnumber());
    }

    @Test   //一对多
    public void Testonttomany() throws IOException {

        Provinces provinces=iProvincesDao.getProvincesByid(1);
        System.out.println(provinces.getPname());

        for (Citys citys : provinces.getCitysSet()) {
            System.out.println(citys.getCname());
        }

    }

    @Test   //多对多
    public void Testmanytomany() throws IOException {

//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config"));
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//
//        IUserDao iUserDao=sqlSession.getMapper(IUserDao.class);
        Users users=iUserDao.getUsersById(2);
        System.out.println(users.getUname());

        for (Roles roles : users.getRoles()) {
            System.out.println(roles.getRname());
        }

//        sqlSession.close();

    }

}
