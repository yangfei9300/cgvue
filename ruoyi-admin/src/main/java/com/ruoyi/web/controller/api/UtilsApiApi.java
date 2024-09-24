package com.ruoyi.web.controller.api;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class UtilsApiApi {


    public static double getfenByTime(int mons){
        if(mons<=30){
            return 1.00;
        }else if(mons<=60){
            return 2.00;
        }else if(mons<=120){
            return 3.00;
        }else{
            return 999.00;
        }
    }

//    获取年月日
    public static DateTimeFormatter getNYRSFM(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);
        System.out.println(formattedDateTime);
            return formatter;
    }

    public static int compareTimeToWorkHours(LocalTime givenTime, LocalTime startTime, LocalTime endTime) {
        // 如果给定时间在上班时间之前
        if (givenTime.isBefore(startTime)) {
            return 1;//给定时间在上班时间之前
        }
        // 如果给定时间在下班时间之后
        else if (givenTime.isAfter(endTime)) {
            return 2;//"给定时间在下班时间之后"
        }
        // 计算给定时间与上班时间和下班时间的差距
        long diffToStart = ChronoUnit.MINUTES.between(startTime, givenTime);
        long diffToEnd = ChronoUnit.MINUTES.between(givenTime, endTime);

        // 判断哪个时间更近
        if (diffToStart < diffToEnd) {
            return 3;//"给定时间离上班时间更近，且在上班时间之后"
        } else if (diffToStart > diffToEnd) {
            return 4;//"给定时间离下班时间更近，且在下班时间之前"
        } else {
            // 理论上这种情况不会发生（除非上班时间和下班时间完全相同），但为了完整性还是处理一下
            return 5;//"给定时间与上班时间和下班时间的距离相同"
        }
    }




//    判断时间是打卡时间
    public static int checkPunchTime(LocalTime startTime, LocalTime endTime, LocalTime punchTime) {
        if (punchTime.isBefore(startTime)) {
            return 1; // 打卡时间在上班时间之前
        } else if (punchTime.isAfter(endTime)) {
            return 2; // 打卡时间在下班时间之后
        } else {
            return 3; // 打卡时间在上班时间与下班时间之间（虽然这个选项在你的场景中可能不常见）
        }
    }
//    获取时分秒
    public static  String strZShuzu( ){
        // 获取当前时间
        LocalTime now = LocalTime.now();

        // 获取小时、分钟和秒
        String hour = now.getHour()<10?"0"+now.getHour():now.getHour()+"";
        String minute = now.getMinute()<10?"0"+now.getMinute():now.getMinute()+"";
        String second =now.getSecond()<10?"0"+now.getSecond():now.getSecond()+"";
        return hour+":"+minute+":"+second;
    }

    public static  String getnianyurei( ){
        // 获取当前日期
        LocalDate today = LocalDate.now();

        // 分解日期以获取年、月、日
        int year = today.getYear();
        int month = today.getMonthValue(); // 注意：getMonth()会返回一个Month枚举，而getMonthValue()返回int
        int day = today.getDayOfMonth();
        return year+"-"+month+"-"+day;
    }

    public static   double[][] strZShuzu( String strArray){
        // 示例字符串，表示二维double数组

        // 移除最外层的方括号
        strArray = strArray.substring(1, strArray.length() - 1);

        // 使用分号分割成多个字符串，每个字符串代表二维数组的一行
        String[] rowsStr = strArray.split(";");

        // 计算二维数组的行数
        int rows = rowsStr.length;

        // 初始化二维数组
        double[][] result = new double[rows][];

        // 遍历每行
        for (int i = 0; i < rows; i++) {
            // 移除行首和行尾的方括号
            rowsStr[i] = rowsStr[i].substring(1, rowsStr[i].length() - 1);

            // 使用逗号分割当前行的字符串，得到double类型的数组
            String[] elementsStr = rowsStr[i].split(",");

            // 根据元素的数量初始化当前行的数组
            result[i] = new double[elementsStr.length];

            // 遍历并转换每个元素
            for (int j = 0; j < elementsStr.length; j++) {
                result[i][j] = Double.parseDouble(elementsStr[j]);
            }
        }
        return result;
    }

}
