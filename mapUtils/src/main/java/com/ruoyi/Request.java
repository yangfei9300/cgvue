package com.ruoyi;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Request {
    public static String getDate () throws IOException {
        // 创建URL对象
        URL url = new URL("https://restapi.amap.com/v3/geocode/geo?address=北京市朝阳区阜通东大街6号&output=XML&key=899e960e3d93e1f07383d12b7f66b1fc");

        // 打开连接
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

        // 设置请求方法为GET
        connection.setRequestMethod("GET");

        // 接收响应码
        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);

        // 读取响应内容
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();


        // 关闭连接
        connection.disconnect();
        return response.toString();
    }
    public static String requestHTTPContent(String strURL, String method) throws Exception {

        URL url = new URL(strURL);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();

        // 设置请求方法，为 "GET" 或 "POST"
        // GET 请求只能传 query 参数，query 参数都是拼在请求地址上的
        // POST 可以传 body 和 query 两种形式的参数
        httpConn.setRequestMethod(method);

        // 请求时是否使用缓存
        httpConn.setUseCaches(false);

        // POST 请求必须设置下面两项
        // 设置是否从 HttpUrlConnection 的对象写
        httpConn.setDoOutput(true);
        // 设置是否从 HttpUrlConnection 的对象读入
        httpConn.setDoInput(true);

        httpConn.connect();

        BufferedReader reader = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));
        String line;
        StringBuffer buffer = new StringBuffer();
        while ((line = reader.readLine()) != null) {
            buffer.append(line);
        }

        reader.close();
        httpConn.disconnect();

        String res = buffer.toString();
        // 输出字符串形式的返回数据
        System.out.println(res);

        return res;

    }
}
