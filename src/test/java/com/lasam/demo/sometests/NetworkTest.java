package com.lasam.demo.sometests;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.*;

/**
 * @author liuhao
 * @date 2020/8/30 03:08
 */
@Slf4j
public class NetworkTest {

    public static void main(String[] args) throws IOException {
        ExecutorService es = Executors.newFixedThreadPool(8);
        File in = new File("/Users/liuhao/downloadurl");
        BufferedReader br = new BufferedReader(new FileReader(in));
        String line;
        while ((line = br.readLine()) != null) {
            String[] tmp = line.split("=");
            String fileName = tmp[tmp.length - 1];

            String url = line;
            es.execute(() -> {
                try {
                    System.out.println(fileName);
                    download(url, fileName);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

    }

    public static void download(String urlPath, String fileName) throws IOException {
        log.info("进入下载文件工具类");
        BufferedInputStream bin = null;
        OutputStream out = null;
        try {
            // 统一资源
            URL url = new URL(urlPath);
            // 连接类的父类，抽象类
            URLConnection urlConnection = url.openConnection();
            // http的连接类
            HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
            // 设定请求的方法，默认是GET
            httpURLConnection.setRequestMethod("GET");
            // 设置字符编码
            httpURLConnection.setRequestProperty("Charset", "UTF-8");
            // 打开到此 URL 引用的资源的通信链接（如果尚未建立这样的连接）。
            httpURLConnection.connect();

            // 文件大小
            int fileLength = httpURLConnection.getContentLength();

            // 文件名
            log.info("开始下载文件：" + fileName);
            log.info("file length---->" + fileLength);

            url.openConnection();

            bin = new BufferedInputStream(httpURLConnection.getInputStream());

            String path = "/Users/liuhao/Downloads/porn/" + fileName;
            File file = new File(path);

            out = new FileOutputStream(file);
            int size;
            int len = 0;
            byte[] buf = new byte[1024 * 1024];
            while ((size = bin.read(buf)) != -1) {
                len += size;
                out.write(buf, 0, size);
                // 打印下载百分比
                if ((len * 100 / fileLength) > 50 && (len * 100 / fileLength) < 55) {
                    System.out.println(fileName + "下载了-------> " + len * 100 / fileLength + "%");
                } else if ((len * 100 / fileLength) >= 98) {
                    System.out.println(fileName + "下载了-------> " + len * 100 / fileLength + "%");
                }
                //log.info("下载了-------> " + len * 100 / fileLength + "%");
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            if (bin != null) {
                bin.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}
