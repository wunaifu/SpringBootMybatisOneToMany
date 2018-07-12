package com.wnf.dao;

import com.wnf.entity.Tutor;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TutorDao {

    public Tutor findTutorById(int courseId);


}
