package com.example.demo.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DataCollection {
	private static Logger logger = LoggerFactory.getLogger("sysLog");
    @RequestMapping(value = "log.gif")
    public void analysis(String args, HttpServletResponse response) throws IOException {
//        System.out.println(args);
    	
//         logger.info("日志："+args);
		//日志收集 
//    	domain=localhost
//    	url=http://localhost:8080/index
//    	title=埋点测试页面
//    	referrer=
//    	sh=864
//    	sw=1536
//    	cd=24
//    	lang=zh-CN
//    	userAgent=Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36
//    	systemName=localhost:8080
//    	account=web-uuid
    	
    	StringBuffer buffer=new StringBuffer();
		String[] attrs= args.split("\\&");
		for (int i = 0; i < attrs.length; i++) {
//			System.out.println(attrs[i]);
			String[] kv=attrs[i].split("=");
			String key=kv[0];
			String val=kv.length==2?kv[1]:"";
			buffer.append(val+"|");
		}
		String loginfo=buffer.toString();
//		System.out.println(loginfo);
		logger.info(loginfo);
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/gif");
        OutputStream out = response.getOutputStream();
        BufferedImage image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        ImageIO.write(image, "gif", out);
        out.flush();
    }
}

