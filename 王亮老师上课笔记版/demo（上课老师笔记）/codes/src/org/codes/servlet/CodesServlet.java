package org.codes.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

@WebServlet("/getcodes")
public class CodesServlet extends HttpServlet {
	// 定义可选择的字符
	private static final String CHARS = "23456789abcdefghjkmnopqrstuvwxyzABCDEFGHJKLMNOPQRSTUVWXYZ";
	static Random random = new Random();

	// 得到一个随机的字符串
	private String getRandomString() {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < 4; i++) { // 生成四个字符
			buffer.append(CHARS.charAt(random.nextInt(CHARS.length())));
		}
		return buffer.toString();
	}

	// 随机背景颜色
	private Color getRandomColor() { // 得到随机颜色
		return new Color(random.nextInt(128) + 127, random.nextInt(128) + 127, random.nextInt(128) + 127);
	}

	private Color getReverseColor(Color c) { // 得到颜色的反色
		return new Color(255 - c.getRed(), 255 - c.getGreen(), 255 - c.getBlue());
	}

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/jpeg"); // 设置输出类型
		// 得到随机字符串
		String randomString = getRandomString();
		// 将getSession（）设置为true，当会话不存在是返回null
		request.getSession(true).setAttribute("randomString", randomString);
		// 设置图片的宽、高
		int width = 80;
		int height = 30;

		Color bcolor = getRandomColor(); // 设置背景色
		Color fcolor = getReverseColor(bcolor); // 前景色

		// 创建一个彩色图片
		BufferedImage bimage = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
		// 创建绘图对象,从bimage上得到的绘制对象，会把数据绘制到bimage上
		Graphics2D g = bimage.createGraphics();
		// 字体样式为宋体,加粗，20磅
		g.setFont(new Font("Vijaya", Font.BOLD, 20));
		// 先画出背景色
		g.setColor(bcolor);
		g.fillRect(0, 0, width, height);

		// 再画出前景色
		g.setColor(fcolor);
		for (int i = 0; i < randomString.length(); i++) {
			// 绘制随机字符
			g.drawString(randomString.charAt(i) + "", 10 + i * 12, 22);
		}

		// 画出干扰点
		for (int i = 0, n = random.nextInt(100); i < n; i++) {
			g.fillRect(random.nextInt(width), random.nextInt(height), 1, 1);
		}

		// 将图像输出到浏览器
		ServletOutputStream outstream = response.getOutputStream();
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(outstream);
		
		encoder.encode(bimage);
		outstream.flush();
		outstream.close();
	}
}
