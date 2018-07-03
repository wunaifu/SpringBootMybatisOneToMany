package com.wnf.dao;

import com.wnf.entity.Card;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface ICardDao {

    @Select("select * from card where uid = #{uid} ")
    public Card getCard(int uid);

}
