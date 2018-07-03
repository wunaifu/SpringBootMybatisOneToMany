package com.wnf.dao;

import com.wnf.entity.Roles;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface IRolesDao {

    //根据用户id得到所有的角色：

    @Select("select * from roles where rid in(select rid from users where uid=1)")
    public List<Roles> getAllRolesByuid(int uid);


}
