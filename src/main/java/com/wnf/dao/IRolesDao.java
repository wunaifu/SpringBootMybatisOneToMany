package com.wnf.dao;

import com.wnf.entity.Roles;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface IRolesDao {

    //根据用户id得到所有的角色：

    @Select("select * from roles where rid in(select rid from users where uid=#{uid})")
    public List<Roles> getAllRolesByuid(int uid);

    @Insert("insert into roles(rname) values(#{user})")
    public int addRole(String user);

    @Insert("insert into roles(rid,rname) values(#{id},#{name})")
    public int addRole2(String name);

    @Delete("delete from roles where rid=#{id}")
    public int deleteRole(int id);
}
