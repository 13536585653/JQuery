package org.yzm.servlet;

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
	// 
	private static final String CHARS = "123456789abcdefghjkmnopqrstuvwxyzABCDEFGHJKLMNOPQRSTUVWXYZ";
	static Random random = new Random();

	// 
	private String getRandomString() {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < 4; i++) { //
			buffer.append(CHARS.charAt(random.nextInt(CHARS.length())));
		}
		return buffer.toString();
	}

	// ���������ɫ
	private Color getRandomColor() { // �õ������ɫ
		return new Color(random.nextInt(128) + 127, random.nextInt(128) + 127, random.nextInt(128) + 127);
	}

	private Color getReverseColor(Color c) { // �õ���ɫ�ķ�ɫ
		return new Color(255 - c.getRed(), 255 - c.getGreen(), 255 - c.getBlue());
	}

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/jpeg"); // �����������
		// �õ�����ַ���
		String randomString = getRandomString();
		
		// 
		request.getSession(true).setAttribute("randomString", randomString);
		// ����ͼƬ�Ŀ���
		int width = 80;
		int height = 30;

		Color bcolor = getRandomColor(); // ���ñ���ɫ
		Color fcolor = getReverseColor(bcolor); // ǰ��ɫ

		// ����һ����ɫͼƬ
		BufferedImage bimage = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
		// ������ͼ����,��bimage�ϵõ��Ļ��ƶ��󣬻�����ݻ��Ƶ�bimage��
		Graphics2D g = bimage.createGraphics();
		// ������ʽΪ����,�Ӵ֣�25��
		g.setFont(new Font("Vijaya", Font.BOLD, 30));
		// �Ȼ�������ɫ
		g.setColor(bcolor);
		g.fillRect(0, 0, width, height);

		// �ٻ���ǰ��ɫ
		g.setColor(fcolor);
		for (int i = 0; i < randomString.length(); i++) {
			// ��������ַ�
			g.drawString(randomString.charAt(i) + "", 10 + i * 12, 22);
		}

		// �������ŵ�
		for (int i = 0, n = random.nextInt(100); i < n; i++) {
			g.fillRect(random.nextInt(width), random.nextInt(height), 1, 1);
		}

		// ��ͼ������������
		ServletOutputStream outstream = response.getOutputStream();
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(outstream);
		
		encoder.encode(bimage);
		outstream.flush();
		outstream.close();
	}
}
