package com.ruoyi;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class TestMain {
    public static void main(String[] args) {
        // 获取当前日期
        LocalDate currentDate = LocalDate.now();
        // 获取当前月份的第一天
        LocalDate firstDayOfMonth = currentDate.with(TemporalAdjusters.firstDayOfMonth());
        // 获取当前月份的最后一天
        LocalDate lastDayOfMonth = currentDate.with(TemporalAdjusters.lastDayOfMonth());

        // 循环遍历当前月份的所有天
        for (LocalDate date = firstDayOfMonth; !date.isAfter(lastDayOfMonth); date = date.plusDays(1)) {
            // 获取当前天是周几
            DayOfWeek dayOfWeek = date.getDayOfWeek();
            // 打印结果
            System.out.println(date + " 是 " + dayOfWeek);
        }
    }
}
