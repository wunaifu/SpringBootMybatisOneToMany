package com.wnf.dao;

import com.wnf.entity.Users;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

@Mapper
public interface IUserDao {

    //根据id得到用户：
    @Select("select * from users where uid = #{uid}")
    @Results({
            @Result(id=true,column="uid",property="uid"),
            @Result(column="uname",property="uname"),
            @Result(column="uid",property="roles",
                    many=@Many(
                            select="com.wnf.dao.IRolesDao.getAllRolesByuid",
                            fetchType= FetchType.LAZY
                    )
            )
    })
    public Users getUsersById(int uid);


}
