package com.wnf.controller;

import com.wnf.entity.Tutor;
import com.wnf.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TutorController {

    @Autowired
    TutorService tutorService;

    /**
     * 获取老师的及其所教的课程，mybatis的一对多查询
     * @param tutorId
     * @return
     */
    @RequestMapping("tutor/{tutorId}")
    public Tutor tutorList(@PathVariable("tutorId") int tutorId) {
        Tutor tutor = tutorService.findTutorById(tutorId);
        return tutor;
    }

}
