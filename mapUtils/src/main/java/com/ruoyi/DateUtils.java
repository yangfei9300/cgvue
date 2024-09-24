package com.ruoyi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class DateUtils {

    public static Date strZhaunDate(String dateStr){
        // 定义日期字符串和格式
        String dateFormat = "yyyy-MM-dd";

        // 创建SimpleDateFormat对象并设置日期格式
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        Date date=null;
        try {
            // 将字符串解析为Date对象
            date = sdf.parse(dateStr);

            // 打印结果，这里直接打印Date对象可能不会直接显示日期字符串，而是显示时间戳
            // 因此，你可能需要再次使用SimpleDateFormat来格式化Date对象以查看日期字符串
            System.out.println("原始字符串: " + dateStr);
            System.out.println("转换为Date对象: " + date); // 这将显示一个时间戳

            // 如果需要查看格式化的日期字符串
            String formattedDate = sdf.format(date);
            System.out.println("格式化的日期字符串: " + formattedDate);

        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("日期字符串格式错误！");
        }
        return date;
    }
    public static String [][] getMonthInfos(){
        // 获取当前日期
        LocalDate currentDate = LocalDate.now();
        // 获取当前月份的第一天
        LocalDate firstDayOfMonth = currentDate.with(TemporalAdjusters.firstDayOfMonth());
        // 获取当前月份的最后一天
        LocalDate lastDayOfMonth = currentDate.with(TemporalAdjusters.lastDayOfMonth());
        String [][] strTimes= new String[getMonthDays()][];
        int count=0;
        // 循环遍历当前月份的所有天
        for (LocalDate date = firstDayOfMonth; !date.isAfter(lastDayOfMonth); date = date.plusDays(1)) {
            // 获取当前天是周几
            DayOfWeek dayOfWeek = date.getDayOfWeek();
            // 打印结果
            System.out.println(date + " 是 " + dayOfWeek);
            String zong=date + "是" + dayOfWeek;

            String [] str=new String[2];
            str[0]=zong.split("是")[0];
            str[1]=zong.split("是")[1];
            strTimes[count]=str;
            count=count+1;
        }
        System.out.printf("/strTimes--"+strTimes.toString()+"---"+count);
        return strTimes;
    }

    public static int getMonthDays(){
        // 获取当前日期
        LocalDate today = LocalDate.now();

        // 获取当前月份的第一天
        LocalDate firstDayOfMonth = today.with(TemporalAdjusters.firstDayOfMonth());

        // 获取当前月份的下一个月的第一天
        LocalDate firstDayOfNextMonth = today.with(TemporalAdjusters.firstDayOfNextMonth());

        // 通过计算下一个月第一天的前一天，得到当前月份的最后一天
        LocalDate lastDayOfMonth = firstDayOfNextMonth.minusDays(1);

        // 获取当前月份的天数
        int daysInMonth = lastDayOfMonth.getDayOfMonth();

        // 打印结果
        System.out.println("当前月份有 " + daysInMonth + " 天。");
        return daysInMonth;
    }
    public static void main(String[] args) {
        getMonthInfos();
    }
}
