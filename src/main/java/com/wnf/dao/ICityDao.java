package com.wnf.dao;

import com.wnf.entity.Citys;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ICityDao {
    @Select("select * from citys where pid=#{pid}")
    public List<Citys> getCitybypid(int pid);
}
