package com.wnf.dao;

import com.wnf.entity.Roles;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IRolesDao {

    //根据用户id得到所有的角色：

    @Select("select * from roles where rid in(select rid from users where uid=#{uid})")
    public List<Roles> getAllRolesByuid(int uid);

    @Insert("insert into roles(rname) values(#{user})")
    public int addRole1(String user);

    @Insert("insert into roles values(#{rid},#{rname})")
    public int addRole2(@Param("rid")int id,@Param("rname")String name);

    @Insert("insert into roles values(#{role.rid},#{role.rname})")
    public int addRole3(@Param("role")Roles role);

    @Update("update roles set rname=#{role.rname} where rid=#{role.rid}")
    public int updateRole(@Param("role")Roles role);//若参数是实体，@Param("role")必须有

    @Delete("delete from roles where rid=#{id}")
    public int deleteRole(int id);
}
