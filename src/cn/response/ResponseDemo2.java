package cn.response;

/*
 * ʹ��location+302 ʵ��ҳ����ض���
 * �����ض���
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
		// �򻯰�����
		// response.sendRedirect("/ServerStudy/adv.html");
		// ��ʱˢ�»�ÿ��n����תҳ��
		// response.setHeader("refresh", "2");// ÿ��2���Զ�ˢ��ҳ��
		// ��n�����ת��ĳҳ��
		// response.getWriter().append("2�����ת�����ҳ��");
		// response.setHeader("refresh", "2;/ServerStudy/adv.html");

		// ����content-type����
		// response.setHeader("content-type", "text/html;charset=utf-8");
		response.setContentType("text/html;charset=utf-8");// ����ļ��

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
