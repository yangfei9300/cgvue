package com.ruoyi;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main1 {

    public static void main(String[] args) throws IOException {
//        hebing2();
//        hebing();
    }


    public static void hebing2(List<List<String>> luststrs) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("考勤表");

        // 创建一个Random对象
        Random random = new Random();
        // 生成一个1000以内的随机数（包括0和999）
        int randomNumber = random.nextInt(1000);
        // 创建行
        Row row1 = sheet.createRow(0);
        String[][] days = DateUtils.getMonthInfos();
        for(int a=0;a<luststrs.get(0).size();a++){
                // 合并单元格
                sheet.addMergedRegion(new CellRangeAddress(
                        0, // 起始行
                        0, // 结束行
                        a*2+1, // 起始列
                        a*2+1+1  // 结束列
                ));
                // 获取合并后的左上角单元格
                Cell mergedCell = row1.createCell( a*2+1); // 注意这里我们使用createCell而不是getCell
                // 设置单元格类型和值
                mergedCell.setCellType(CellType.STRING);
                mergedCell.setCellValue(luststrs.get(0).get(a));
        }
        for(int a=0;a<luststrs.size();a++){
            if(a>0){
                Row row = (Row) sheet.createRow(a);
                for (int b=0;b<luststrs.get(a).size();b++){
                    // 在行中创建Cell（单元格），并设置值
                    Cell cell = row.createCell(b);
                    cell.setCellValue(luststrs.get(a).get(b));
                }
            }
        }
        // 写入文件
        try (FileOutputStream outputStream = new FileOutputStream(randomNumber+"example.xlsx")) {
            workbook.write(outputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        workbook.close();
    }


    public static FileOutputStream hebing3(List<List<String>> luststrs, HttpServletResponse response) throws IOException {


        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("考勤表");

        // 创建一个Random对象
        Random random = new Random();
        // 生成一个1000以内的随机数（包括0和999）
        int randomNumber = random.nextInt(1000);
        // 创建行
        Row row1 = sheet.createRow(0);
        String[][] days = DateUtils.getMonthInfos();
        for(int a=0;a<luststrs.get(0).size();a++){
            // 合并单元格
            sheet.addMergedRegion(new CellRangeAddress(
                    0, // 起始行
                    0, // 结束行
                    a*2+1, // 起始列
                    a*2+1+1  // 结束列
            ));
            // 获取合并后的左上角单元格
            Cell mergedCell = row1.createCell( a*2+1); // 注意这里我们使用createCell而不是getCell
            // 设置单元格类型和值
            mergedCell.setCellType(CellType.STRING);
            mergedCell.setCellValue(luststrs.get(0).get(a));
        }
        for(int a=0;a<luststrs.size();a++){
            if(a>0){
                Row row = (Row) sheet.createRow(a);
                for (int b=0;b<luststrs.get(a).size();b++){
                    // 在行中创建Cell（单元格），并设置值
                    Cell cell = row.createCell(b);
                    cell.setCellValue(luststrs.get(a).get(b));
                    createColor(workbook,cell,luststrs.get(a).get(b));
                }
            }
        }
        FileOutputStream outputStream=new FileOutputStream(randomNumber+"example.xlsx");
        workbook.write(response.getOutputStream());
        workbook.close();
        return outputStream;
    }


    public static Cell  createColor( Workbook workbook,Cell cell,String type){
        CellStyle style = workbook.createCellStyle();
        if(type.equals("正常")){
            style.setFillForegroundColor(IndexedColors.WHITE.getIndex()); // 设置前景颜色为黄色
            style.setFillPattern(FillPatternType.SOLID_FOREGROUND); // 设置背景填充样式
        }else if(type.equals("迟到")){
            style.setFillForegroundColor(IndexedColors.YELLOW.getIndex()); // 设置前景颜色为黄色
            style.setFillPattern(FillPatternType.SOLID_FOREGROUND); // 设置背景填充样式
        }else if(type.equals("早退")){
            style.setFillForegroundColor(IndexedColors.RED.getIndex()); // 设置前景颜色为黄色
            style.setFillPattern(FillPatternType.SOLID_FOREGROUND); // 设置背景填充样式
        }else if(type.equals("缺卡")){
            style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex()); // 设置前景颜色为黄色
            style.setFillPattern(FillPatternType.SOLID_FOREGROUND); // 设置背景填充样式
        }


        cell.setCellStyle(style);
        return cell;
    }

    public static void hebing() {

        String[][] days = DateUtils.getMonthInfos();
        // 创建一个Workbook（工作簿）
        Workbook workbook = new XSSFWorkbook();
        // 创建一个Sheet（工作表）
        Sheet sheet = workbook.createSheet("考勤表");
        // 填充数据
//        Row row1 = sheet.createRow(1);
//        for (int a = 0; a < days.length; a++) {
//            Cell cell1 = row1.createCell(a);
//            cell1.setCellValue(days[a][0]);
//        }
        Row row1 = sheet.createRow(1);
        List<String> daysStrs=new ArrayList<>();
        for(int a=0;a<days.length;a++){
            daysStrs.add(days[a][0]);
            daysStrs.add(days[a][0]);
        }
        for(int a=0;a<daysStrs.size();a++){
            if(a%2==0){
                Cell cell2 = row1.createCell(a);
                cell2.setCellValue(daysStrs.get(a));
                sheet.addMergedRegion(new CellRangeAddress(
                        0, // first row (0-based)//合并开始第一行
                        1, // last row  (0-based)//合并结束的行数
                        a, // first column (0-based)//合并开始的列数
                        a+1  // last column (0-based)//合并结束的列数
                ));
            }else{
                Cell cell1 = row1.createCell(a);
                cell1.setCellValue(daysStrs.get(a));
            }
        }



        // 获取当前工作目录的路径
        String currentDir = System.getProperty("user.dir");
        // 指定Excel文件的保存路径和文件名
        String filePath = currentDir + File.separator + "example.xlsx";
        System.out.printf("filePath--" + filePath);
        // 使用FileOutputStream写入文件
        try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
            workbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                workbook.close(); // 关闭Workbook
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    //    生成文件，无合并单元格
    public void wuhebing() throws IOException {
        // 创建一个Workbook（工作簿）
        Workbook workbook = new XSSFWorkbook();

        // 创建一个Sheet（工作表）
        Sheet sheet = (Sheet) workbook.createSheet("Example Sheet");

        // 创建一个Row（行），参数为行号（从0开始）
        Row row = (Row) sheet.createRow(0);

        // 在行中创建Cell（单元格），并设置值
        Cell cell = row.createCell(0);
        cell.setCellValue("Hello");

        // 创建另一行并设置值
        Row row2 = (Row) sheet.createRow(1);
        Cell cell2 = row2.createCell(0);
        cell2.setCellValue("World!");

        // 获取当前工作目录的路径
        String currentDir = System.getProperty("user.dir");
        // 指定Excel文件的保存路径和文件名
        String filePath = currentDir + File.separator + "workbook_apachepoi.xlsx";

        // 使用FileOutputStream写入文件
        try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
            workbook.write(outputStream);
        }
        // 关闭Workbook
        workbook.close();
        System.out.println("Excel文件已保存到：" + filePath);
    }
}