package com.ruoyi.CgTreatDoMat.controller;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class DownloadAndZipImages1 {

    public  void getZip(List<String> wenjianjias,List<List<String>> imgssss,String filename) throws IOException {
        String qianW="";
        String[] directories = new String[wenjianjias.size()];

        for(int a=0;a<directories.length;a++){
            directories[a]=wenjianjias.get(a);
        }

        // 下载并保存图片
        for (int i = 0; i < imgssss.size(); i++) {

            String[] imageUrls = {
                    "https://frd-yhc.oss-cn-hangzhou.aliyuncs.com/2023/5/7/cfdf7bd5a8714e9cb80ece23b4015b9c.jpg",
                    "https://frd-yhc.oss-cn-hangzhou.aliyuncs.com/2023/5/7/cfdf7bd5a8714e9cb80ece23b4015b9c.jpg",
                    "https://frd-yhc.oss-cn-hangzhou.aliyuncs.com/2023/5/7/cfdf7bd5a8714e9cb80ece23b4015b9c.jpg",
                    "https://frd-yhc.oss-cn-hangzhou.aliyuncs.com/2023/5/7/cfdf7bd5a8714e9cb80ece23b4015b9c.jpg",
                    "https://frd-yhc.oss-cn-hangzhou.aliyuncs.com/2023/5/7/cfdf7bd5a8714e9cb80ece23b4015b9c.jpg",
            };
            List<String> lustimg=imgssss.get(i);

            String directory = qianW+wenjianjias.get(i);

            // 确保目录存在
            Files.createDirectories(Paths.get(directory));

            for (int a=0;a<lustimg.size();a++){
                Random rand = new Random();
                // 生成一个0（‌包括）‌到100（‌不包括）‌之间的随机数
                int randomNum = rand.nextInt(100);
                String fileName = directory + "/image"+randomNum+".jpg";
                try (InputStream is = new URL(lustimg.get(a)).openStream(); FileOutputStream fos = new FileOutputStream(fileName)) {
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = is.read(buffer)) != -1) {
                        fos.write(buffer, 0, bytesRead);
                    }
                } catch (IOException e) {
                    System.err.println("Error downloading or saving image " + lustimg.get(a) + ": " + e.getMessage());
                }
            }
        }

        // 压缩文件夹
        String zipFileName = "/www/wwwroot/cgjava.zsyflive.com/profile/"+filename+".zip";
        try (FileOutputStream fos = new FileOutputStream(zipFileName);
             ZipOutputStream zos = new ZipOutputStream(fos)) {

            for (String dir : directories) {

                File folder = new File(qianW+dir);
                File[] filesInFolder = folder.listFiles();
                if (filesInFolder != null) {
                    for (File file : filesInFolder) {
                        ZipEntry zipEntry = new ZipEntry(qianW+dir + File.separator + file.getName());
                        zos.putNextEntry(zipEntry);
                        FileInputStream fis = new FileInputStream(file);
                        byte[] buffer = new byte[1024];
                        int length;
                        while ((length = fis.read(buffer)) >= 0) {
                            zos.write(buffer, 0, length);
                        }
                        zos.closeEntry();
                        fis.close();
                    }
                }
            }

            System.out.println("压缩完成，‌文件名为：‌" + zipFileName);
        } catch (IOException e) {
            System.err.println("Error creating zip file: " + e.getMessage());
        }
    }
}
