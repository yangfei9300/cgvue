package com.ruoyi.web.controller;
import org.springframework.stereotype.Component;
/**
 * 定时任务调度测试
 *
 * @author ruoyi
 */
//com.ruoyi.web.controller.CgTaskKq.newKaoqinData()
@Component("cgTaskKq")
public class CgTaskKq
{
    public void newKaoqinData(String params)
    {
        System.out.println("定时生成考勤");
    }
}
