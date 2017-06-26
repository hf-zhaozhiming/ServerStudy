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

		// ���÷��������ص�״̬��
		// response.setStatus(404);

		// ����404״̬�룬��404����ҳ��
		// response.sendError(404);

		// �޸���Ӧͷ
		// response.setHeader("server", "weblogic");

		// �޸�ʵ������
		// ʹ���ַ������
		// response.setContentType("text/html;charset=utf-8");
		// response.getWriter().append("�ַ������ test!");

		// ʹ���ֽ������
		response.setCharacterEncoding("utf-8");
		response.getOutputStream().write("�ֽ������ test".getBytes());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
