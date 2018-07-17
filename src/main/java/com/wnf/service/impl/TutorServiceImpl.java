package com.wnf.service.impl;

import com.wnf.dao.IRolesDao;
import com.wnf.dao.IUserDao;
import com.wnf.dao.TutorDao;
import com.wnf.entity.Roles;
import com.wnf.entity.Tutor;
import com.wnf.entity.Users;
import com.wnf.service.TutorService;
import com.wnf.util.MyThrowException;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

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

    /**
     * 通过@Transactional，实现了事务操作。
     * Spring的AOP即声明式事务管理默认是针对unchecked exception回滚。
     * 也就是默认对RuntimeException()异常或是其子类进行事务回滚；checked异常,即Exception可try{}捕获的不会回滚，
     * 因此对于我们自定义异常，通过rollbackFor进行设定，后续会单独讲
     * 1、如果我们需要捕获异常后，同时进行回滚，通过TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();进行手动回滚操作。
     * 2、这个方法有待测试：使用Object savePoint = TransactionAspectSupport.currentTransactionStatus().createSavepoint();
     * 设置回滚点，使用TransactionAspectSupport.currentTransactionStatus().rollbackToSavepoint(savePoint);回滚到savePoint。
     * @param user
     * @return
     */
    @Transactional
    @Override
    public String addUser(Users user) {
        try {
            int addUserRe = iUserDao.addUser(user.getUname());
            if (addUserRe == 1) {
                Roles roles = new Roles();
                roles.setRid(10);
                roles.setRname("10");
                int delRoleRe = iRolesDao.deleteRole(roles.getRid());
                System.out.println("delRoleRe==============="+delRoleRe);
                if (delRoleRe == 1) {
                    return "success";
                } else {
                    throw new MyThrowException("Role删除失败,数据回滚");
                }
            } else {
                throw new MyThrowException("User添加失败，数据回滚");
            }
        } catch (MyThrowException e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            throw e;
        }
    }
}
