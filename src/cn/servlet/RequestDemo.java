package cn.servlet;

/*
 * ʹ��request����ط�����ȡ�����У�����ͷ���������
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
		// ��ȡ�����е������Ϣ
		getRows(request, response);
		// ��ȡ����ͷ���������
		getHeader(request, response);

	}

	private void getRows(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.getWriter().append("���󷽷�Ϊ��").append(request.getMethod()).append("<br/>URI:")
				.append(request.getRequestURI()).append("<br/>HttpЭ��Ϊ:").append(request.getProtocol() + "<br/>");
	}

	private void getHeader(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.getWriter().append("��������host��").append(request.getHeader("host") + "<br/>");// �������ƻ�ȡͷֵ
		response.getWriter().append("������ԴrefererΪ��").append(request.getHeader("referer") + "<br/>");// ��ȡ���ʸ���ҳ����Դ
		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String header = headerNames.nextElement();
			String value = request.getHeader(header);
			response.getWriter().append(header + " ֵΪ:").append(value + "<br/>");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ��ȡʵ��������ݣ�����Ҫ��post�ύ�������ڱ�actionѡ����ָ����servlet����ʽΪ/��վ����/servlet��������
		resp.setContentType("text/html;charset=utf-8");
		ServletInputStream inputStream = req.getInputStream();
		byte[] buf = new byte[1024];
		int len = 0;
		while ((len = inputStream.read(buf)) != -1) {
			resp.getWriter().append(new String(buf, 0, len) + "<br/>");
		}
	}
}
