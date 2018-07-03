package com.wnf.dao;

import com.wnf.entity.Person;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

@Mapper
public interface IPersonDao {

    @Select("select * from person where pid = #{pid}")
    @Results({
            @Result(id=true,column="pid",property="pid"),
            @Result(column="pname",property="pname"),
            @Result(column="page",property="page"),
            @Result(column="pid",property="card",one=@One(select="com.wnf.dao.ICardDao.getCard",fetchType= FetchType.EAGER))
    })
    public Person getPerson(int pid);
}
