package com.wnf.service;

import com.wnf.entity.Tutor;
import com.wnf.entity.Users;

public interface TutorService {

    public Tutor findTutorById(int courseId);

    public String addUser(Users user);
}
