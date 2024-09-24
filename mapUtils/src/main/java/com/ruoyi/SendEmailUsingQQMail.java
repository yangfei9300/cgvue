package com.ruoyi;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmailUsingQQMail {

    public static void main(String[] args) {


    }
    public static void  toSendEmail(String receiveEmail,String content) throws MessagingException {
        // 发件人电子邮箱
        final String from = "2855299844@qq.com";

        // 授权码，不是QQ密码
        final String password = "mahbybunknlpdfje";

        // SMTP服务器地址
        String host = "smtp.qq.com";

        // 获取系统属性
        Properties properties = System.getProperties();

        // 设置邮件服务器
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // 获取默认的Session对象
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });
//        try {
            // 创建默认的MimeMessage对象
            MimeMessage message = new MimeMessage(session);

            // 设置From:头部头字段
            message.setFrom(new InternetAddress(from));

            // 设置To:头部头字段
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiveEmail));

            // 设置Subject:头部头字段
            message.setSubject("邮件");

            // 设置消息体
            message.setText(content);

            // 发送消息
            Transport.send(message);
            System.out.println("Sent message successfully....");
//        } catch (MessagingException mex) {
//            mex.printStackTrace();
//        }
    }
}