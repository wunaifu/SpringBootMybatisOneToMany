package com.wnf.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

@Configuration
@EnableScheduling
public class SchedulingConfig {

    // 通过@Scheduled声明该方法是计划任务，使用fixedRate属性每隔固定时间5秒执行一次
    //1.@Scheduled(fixedRate = 5000)// 使用cron属性可按照指定时间执行，本例指的是每10分钟执行一次；
    //2.@Scheduled(cron = “0 0/10 * * * ?”) // 每10分钟执行一次
    @Scheduled(cron = "0 * * * * ?")
    public void getToken() {
        System.out.println("定时任务："+new Date());
    }
}
