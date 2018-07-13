package com.wnf.service.impl;

import com.wnf.dao.IRolesDao;
import com.wnf.dao.IUserDao;
import com.wnf.dao.TutorDao;
import com.wnf.entity.Roles;
import com.wnf.entity.Tutor;
import com.wnf.entity.Users;
import com.wnf.service.TutorService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TutorServiceImpl implements TutorService {

    @Autowired
    TutorDao tutorDao;
    @Autowired
    IUserDao iUserDao;
    @Autowired
    IRolesDao iRolesDao;


    @Override
    public Tutor findTutorById(int tutorId) {
        Tutor tutor = tutorDao.findTutorById(tutorId);
        return tutor;
    }

    @Transactional
    @Override
    public String addUser(Users user) {
        System.out.println("addUser:" + iUserDao.addUser(user));
        Roles roles = new Roles();
        roles.setRname("测试");
        System.out.println("addRole:" + iRolesDao.addRole(roles));
        return null;
    }
}
