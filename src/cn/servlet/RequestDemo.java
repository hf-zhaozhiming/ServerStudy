package cn.servlet;

/*
 * 使用request的相关方法获取请求行，请求头的相关内容
 */
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestDemo
 */
public class RequestDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		// 获取请求行的相关信息
		getRows(request, response);
		// 获取请求头的相关内容
		getHeader(request, response);

	}

	private void getRows(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.getWriter().append("请求方法为：").append(request.getMethod()).append("<br/>URI:")
				.append(request.getRequestURI()).append("<br/>Http协议为:").append(request.getProtocol() + "<br/>");
	}

	private void getHeader(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.getWriter().append("请求主机host：").append(request.getHeader("host") + "<br/>");// 根据名称获取头值
		response.getWriter().append("请求来源referer为：").append(request.getHeader("referer") + "<br/>");// 获取访问该网页的来源
		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String header = headerNames.nextElement();
			String value = request.getHeader(header);
			response.getWriter().append(header + " 值为:").append(value + "<br/>");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取实体相关内容，这需要用post提交，可以在表单action选项中指定该servlet，方式为/网站名称/servlet访问名称
		resp.setContentType("text/html;charset=utf-8");
		ServletInputStream inputStream = req.getInputStream();
		byte[] buf = new byte[1024];
		int len = 0;
		while ((len = inputStream.read(buf)) != -1) {
			resp.getWriter().append(new String(buf, 0, len) + "<br/>");
		}
	}
}
