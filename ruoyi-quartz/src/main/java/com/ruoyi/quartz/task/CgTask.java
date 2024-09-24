package com.ruoyi.quartz.task;

import org.springframework.stereotype.Component;
//com.ruoyi.quartz.task.CgTask
@Component("cgTask")
public class CgTask {
    //考勤
    public void newKaoqin(String params)
    {
        System.out.println("执行有参方法：" + params);
    }
}
