package cn.response;

/*
 * 使用location+302 实现页面的重定向
 * 请求重定向
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResponseDemo2
 */
public class ResponseDemo2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// response.setStatus(302);
		// response.setHeader("location", "/ServerStudy/adv.html");
		// 简化版如下
		// response.sendRedirect("/ServerStudy/adv.html");
		// 定时刷新或每隔n秒跳转页面
		// response.setHeader("refresh", "2");// 每隔2秒自动刷新页面
		// 隔n秒后跳转到某页面
		// response.getWriter().append("2秒后跳转到广告页面");
		// response.setHeader("refresh", "2;/ServerStudy/adv.html");

		// 设置content-type内容
		// response.setHeader("content-type", "text/html;charset=utf-8");
		response.setContentType("text/html;charset=utf-8");// 上面的简版

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
