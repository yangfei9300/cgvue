package com.ruoyi.CgTreatDoMat.controller;

import java.io.*;
import java.net.URL;
import java.nio.file.*;
import java.util.Random;
import java.util.zip.*;

public class DownloadAndZipImages {
    public static void main(String[] args) throws IOException {
        String[] imageUrls = {
                "https://frd-yhc.oss-cn-hangzhou.aliyuncs.com/2023/5/7/cfdf7bd5a8714e9cb80ece23b4015b9c.jpg",
                "https://frd-yhc.oss-cn-hangzhou.aliyuncs.com/2023/5/7/cfdf7bd5a8714e9cb80ece23b4015b9c.jpg",
                "https://frd-yhc.oss-cn-hangzhou.aliyuncs.com/2023/5/7/cfdf7bd5a8714e9cb80ece23b4015b9c.jpg",
                "https://frd-yhc.oss-cn-hangzhou.aliyuncs.com/2023/5/7/cfdf7bd5a8714e9cb80ece23b4015b9c.jpg",
                "https://frd-yhc.oss-cn-hangzhou.aliyuncs.com/2023/5/7/cfdf7bd5a8714e9cb80ece23b4015b9c.jpg",
        };

        String[] directories = {
                "folder1",
                "folder2",
                "folder3",
                "folder4",
                "folder5"
        };

        String zipFileName = "images.zip";

        // 下载图片并保存到指定的文件夹
        for (int i = 0; i < imageUrls.length; i++) {
            Path directory = Paths.get(directories[i]);
            Files.createDirectories(directory);

            // 创建一个Random实例
            Random rand = new Random();
            // 生成一个0（‌包括）‌到100（‌不包括）‌之间的随机数
            int randomNum = rand.nextInt(100);

            Path filePath = directory.resolve(randomNum+"image.jpg");
            try (InputStream is = new URL(imageUrls[i]).openStream();
                 FileOutputStream fos = new FileOutputStream(filePath.toFile())) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = is.read(buffer)) != -1) {
                    fos.write(buffer, 0, bytesRead);
                }
            } catch (IOException e) {
                System.err.println("Error downloading image " + imageUrls[i] + ": " + e.getMessage());
            }
        }

        // 将文件夹压缩成一个压缩包
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFileName))) {
            for (String dir : directories) {
                Path directoryPath = Paths.get(dir);
                Files.walk(directoryPath)
                        .filter(path -> !Files.isDirectory(path))
                        .forEach(path -> {
                            ZipEntry zipEntry = new ZipEntry(directoryPath.relativize(path).toString());
                            try {
                                zos.putNextEntry(zipEntry);
                                Files.copy(path, zos);
                                zos.closeEntry();
                            } catch (IOException e) {
                                System.err.println("Error adding file to zip: " + path + ": " + e.getMessage());
                            }
                        });
            }
        } catch (IOException e) {
            System.err.println("Error creating zip file: " + zipFileName + ": " + e.getMessage());
        }

        System.out.println("All images downloaded and zipped into " + zipFileName);
    }
}
