package cn.servlet;

/*
 * ��ȡget��post��ʽ�ύ�Ĳ�����Ϣ
 */
import java.io.IOException;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestParameter
 */
public class RequestParameter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ���ñ����׼,ֻ��post�ύ�ķ�ʽ��Ч,get��ʽ��Ҫ�ֶ�����
		request.setCharacterEncoding("utf-8");
		//
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append("<hr/>");
		// ʹ��getParameter���� ��ȡָ���������ƵĲ���ֵ
		response.getWriter().append("ʹ��getParameter��������ȡָ��������Ϣ<br/>");
		String paraValue = request.getParameter("name");
		// ���ʹ��get��������Ҫ�ֹ�����
		if (request.getMethod().equals("GET")) {
			paraValue = new String(paraValue.getBytes("ISO-8859-1"), "UTF-8");
		}
		response.getWriter().append("getParameter name :" + paraValue + "<br/>");
		response.getWriter().append("<hr/>");

		//
		String[] parameterValues = request.getParameterValues("name");
		String nameValues = "";
		for (String s : parameterValues) {
			nameValues = nameValues + "," + s;
		}
		response.getWriter().append("getParameterValues name :" + nameValues + "<br/>");
		response.getWriter().append("<hr/>");

		// ʹ��getParameterNames���� �������洫�ݹ��������в���������ֵ
		Enumeration<String> parameterNames = request.getParameterNames();
		response.getWriter().append("getParameterNames" + "<br/>");
		while (parameterNames.hasMoreElements()) {
			String parameter = parameterNames.nextElement();
			String parameterValue = request.getParameter(parameter);
			response.getWriter().append(parameter + " : ").append(parameterValue + "<br/>");
		}
		response.getWriter().append("<hr/>");
		// ʹ��getParameterMap������������ȡ���в�����Ϣ
		Map<String, String[]> map = request.getParameterMap();
		response.getWriter().append("ʹ��getParameterMap������������ȡ���в�����Ϣ,map������ʽ1<br/>");
		// map������ʽ1
		Set<String> keySet = map.keySet();
		for (String key : keySet) {
			String[] keyValue = map.get(key);
			String lastValue = "";
			for (String value : keyValue) {
				lastValue = lastValue + ";" + value;
			}
			response.getWriter().append(key + " :" + lastValue + "<br/>");
		}
		response.getWriter().append("ʹ��getParameterMap������������ȡ���в�����Ϣ,map������ʽ2<br/>");
		// map������ʽ2
		Set<Entry<String, String[]>> entrySet = map.entrySet();
		for (Entry<String, String[]> entry : entrySet) {
			String para = entry.getKey();
			String[] value = entry.getValue();
			String lastValue = "";
			for (String val : value) {
				lastValue = lastValue + ";" + val;
			}
			response.getWriter().append(para + " :" + lastValue.toString() + "<br/>");
		}
		response.getWriter().append("ʹ��getParameterMap������������ȡ���в�����Ϣ,map������ʽ3<br/>");
		// map������ʽ3 �׶� ֻ���õ�ֵ���ò�����
		Collection<String[]> values = map.values();
		for (String[] str : values) {
			String lastValue = "";
			for (String val : str) {
				lastValue = lastValue + ";" + val;
			}
			response.getWriter().append(lastValue + "<br/>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
