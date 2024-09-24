package com.ruoyi;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class test1 {
    public static void main1(String[] args) {
        // 定义时间字符串
        String dateTimeStr = "2024-08-06 09:25:52";

        // 定义日期时间格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd' 'HH:mm:ss");

        // 将字符串转换为LocalDateTime
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr, formatter);

        // 加上100小时
        LocalDateTime newDateTime = dateTime.plusHours(100);

        // 格式化新的日期时间并打印
        String newDateTimeStr = newDateTime.format(formatter);
        System.out.println("新的日期时间是: " + newDateTimeStr);
    }
    public static void main2(String[] args) {
        // 获取当前日期
        LocalDate today = LocalDate.now();
        // 获取前一天的日期
        LocalDate yesterday = today.minusDays(1);
        // 输出前一天的日期
        System.out.println("前一天的日期: " + yesterday);
    }

    public static void main3(String[] args) {
        // 假设有两个 LocalTime 值
        LocalTime time1 = LocalTime.of(10, 30); // 10:30
        LocalTime time2 = LocalTime.of(12, 45); // 12:45

        // 计算两个时间之间的分钟差
        long minutesDifference = Duration.between(time1, time2).toMinutes();

        System.out.println("时间差（分钟）: " + minutesDifference);
    }

    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(0);
        System.out.printf("yesterday--"+yesterday);
    }
}
