package com.ruoyi.CgAttendance.controller;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
public class DateRangeCalculator {

    public static String[] calculateDateRangeAsStrings(String startDateStr, String endDateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = LocalDate.parse(startDateStr, formatter);
        LocalDate endDate = LocalDate.parse(endDateStr, formatter);

        List<String> dateList = new ArrayList<>();

        LocalDate currentDate = startDate;
        while (!currentDate.isAfter(endDate)) {
            dateList.add(currentDate.format(formatter)); // 将LocalDate转换为String并添加到列表中
            currentDate = currentDate.plusDays(1);
        }

        // 将List<String>转换为String[]
        return dateList.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String startDate = "2023-01-01";
        String endDate = "2023-01-05";

        String[] dates = calculateDateRangeAsStrings(startDate, endDate);

        for (String date : dates) {
            System.out.println(date);
        }
    }
}