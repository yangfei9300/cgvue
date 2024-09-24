package com.ruoyi.CgTreatDoMat.controller;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DownloadImages {
    public static void main(String[] args) {
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

        for (int i = 0; i < imageUrls.length; i++) {
            try {
                URL url = new URL(imageUrls[i]);
                String directory = directories[i];
                String fileName = directory + "/image" + (i + 1) + ".jpg";

                // 确保目录存在
                Files.createDirectories(Paths.get(directory));

                try (InputStream is = url.openStream(); FileOutputStream fos = new FileOutputStream(fileName)) {
                    int bytesRead;
                    byte[] buffer = new byte[1024];
                    while ((bytesRead = is.read(buffer)) != -1) {
                        fos.write(buffer, 0, bytesRead);
                    }
                }
                System.out.println("Image downloaded to " + fileName);
            } catch (Exception e) {
                System.err.println("Error downloading image " + imageUrls[i] + ": " + e.getMessage());
            }
        }
    }
}