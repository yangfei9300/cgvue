package com.ruoyi.web.controller.dianzizhang;
import org.apache.poi.xwpf.usermodel.*;
import org.apache.poi.util.Units;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


import org.apache.poi.xwpf.usermodel.*;
import org.apache.poi.util.Units;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

import org.apache.poi.xwpf.usermodel.*;
import org.apache.poi.util.Units;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;




public class WordImageInserter {
    public static void main(String[] args) {
//        ff1();
        ff2();
    }


    public static void ff1(){
        try {
            // 打开已有的Word文档
            XWPFDocument document = new XWPFDocument(new FileInputStream("F:\\新建文件夹\\招展合同\\第五届山东体育用品博览会1.docx"));

            // 创建一个新的段落
            XWPFParagraph paragraph = document.createParagraph();

            // 插入电子章图片（在上层）
            XWPFRun runForSeal = paragraph.createRun();
            try (FileInputStream sealImage = new FileInputStream("F:\\新建文件夹\\招展合同\\zhang.png")) {
                runForSeal.addPicture(sealImage, XWPFDocument.PICTURE_TYPE_PNG,
                        "F:\\新建文件夹\\招展合同\\zhang.png", Units.toEMU(100), Units.toEMU(100)); // 宽高可以根据需求调整
            }

            // 插入签名图片（在下层）
            XWPFRun runForSignature = paragraph.createRun();
            try (FileInputStream signatureImage = new FileInputStream("F:\\新建文件夹\\招展合同\\qianming.png")) {
                runForSignature.addPicture(signatureImage, XWPFDocument.PICTURE_TYPE_PNG,
                        "F:\\新建文件夹\\招展合同\\qianming.png", Units.toEMU(80), Units.toEMU(80)); // 宽高可以根据需求调整
            }

            // 保存文档
            try (FileOutputStream out = new FileOutputStream("输出合同.docx")) {
                document.write(out);
            }
            System.out.println("图片插入成功！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void ff2(){
        try {
            // 读取签名和电子章图片
            BufferedImage signatureImage = ImageIO.read(new File("F:\\新建文件夹\\招展合同\\qianming.png"));
            BufferedImage sealImage = ImageIO.read(new File("F:\\新建文件夹\\招展合同\\zhang.png"));

            // 创建一个新图片，将签名和电子章叠加
            int width = Math.max(signatureImage.getWidth(), sealImage.getWidth());
            int height = Math.max(signatureImage.getHeight(), sealImage.getHeight());

            BufferedImage combinedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g = combinedImage.createGraphics();

            // 先画签名，再画电子章（电子章在签名上方）
            g.drawImage(signatureImage, 0, 0, null);
            g.drawImage(sealImage, 0, 0, null);
            g.dispose();

            // 保存合成图片
            File outputFile = new File("合成图片.png");
            ImageIO.write(combinedImage, "PNG", outputFile);

            // 插入合成后的图片到Word
            XWPFDocument document = new XWPFDocument(new FileInputStream("F:\\新建文件夹\\招展合同\\第五届山东体育用品博览会1.docx"));
            XWPFParagraph paragraph = document.createParagraph();
            XWPFRun run = paragraph.createRun();

            try (FileInputStream imageInputStream = new FileInputStream(outputFile)) {
                run.addPicture(imageInputStream, XWPFDocument.PICTURE_TYPE_PNG, "合成图片.png", Units.toEMU(width), Units.toEMU(height));
            }

            // 保存文档
            try (FileOutputStream out = new FileOutputStream("输出合同.docx")) {
                document.write(out);
            }

            System.out.println("图片叠加并插入成功！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
