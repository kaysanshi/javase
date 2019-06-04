package com.zcib.servlet;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zcib.util.VerifyCode;

public class VerifyCodeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 在页面输出验证码
		 * 1.先获取包含验证码的图片
		 * 2.将验证码保存在session中，以便用户输入验证码后比对
		 * 3.将图片通过输出流输出。
		 */
		VerifyCode verifyCode = new VerifyCode();
		BufferedImage image = verifyCode.getImage();
		request.getSession().setAttribute("verifyCode", verifyCode.getText());
		verifyCode.output(image, response.getOutputStream());
	}

}
