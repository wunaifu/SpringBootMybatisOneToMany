package com.wnf.dao;

import com.wnf.entity.Card;
import com.wnf.entity.Provinces;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

@Mapper
public interface IProvincesDao {

    @Select("select * from provinces where pid = #{pid}")
    @Results({
            @Result(id=true,column="pid",property="pid"),
            @Result(column="pname",property="pname"),
            @Result(column="pid",property="citysSet",
                    many=@Many(
                            select="com.wnf.dao.ICityDao.getCitybypid",
                            fetchType= FetchType.LAZY
                    )
            )
    })
    public Provinces getProvincesByid(int pid);

}
