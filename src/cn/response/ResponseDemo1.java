package cn.response;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResponseDemo1
 */
public class ResponseDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 设置服务器返回的状态码
		// response.setStatus(404);

		// 返回404状态码，加404错误页面
		// response.sendError(404);

		// 修改响应头
		// response.setHeader("server", "weblogic");

		// 修改实体内容
		// 使用字符流输出
		// response.setContentType("text/html;charset=utf-8");
		// response.getWriter().append("字符流输出 test!");

		// 使用字节流输出
		response.setCharacterEncoding("utf-8");
		response.getOutputStream().write("字节流输出 test".getBytes());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
