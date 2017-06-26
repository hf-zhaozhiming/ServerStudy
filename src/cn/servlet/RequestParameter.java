package cn.servlet;

/*
 * 获取get或post方式提交的参数信息
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
		// 设置编码标准,只对post提交的方式有效,get方式需要手动解码
		request.setCharacterEncoding("utf-8");
		//
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append("<hr/>");
		// 使用getParameter方法 获取指定参数名称的参数值
		response.getWriter().append("使用getParameter方法来获取指定参数信息<br/>");
		String paraValue = request.getParameter("name");
		// 如果使用get方法，需要手工解码
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

		// 使用getParameterNames方法 遍历界面传递过来的所有参数及参数值
		Enumeration<String> parameterNames = request.getParameterNames();
		response.getWriter().append("getParameterNames" + "<br/>");
		while (parameterNames.hasMoreElements()) {
			String parameter = parameterNames.nextElement();
			String parameterValue = request.getParameter(parameter);
			response.getWriter().append(parameter + " : ").append(parameterValue + "<br/>");
		}
		response.getWriter().append("<hr/>");
		// 使用getParameterMap方法来遍历获取所有参数信息
		Map<String, String[]> map = request.getParameterMap();
		response.getWriter().append("使用getParameterMap方法来遍历获取所有参数信息,map遍历方式1<br/>");
		// map遍历方式1
		Set<String> keySet = map.keySet();
		for (String key : keySet) {
			String[] keyValue = map.get(key);
			String lastValue = "";
			for (String value : keyValue) {
				lastValue = lastValue + ";" + value;
			}
			response.getWriter().append(key + " :" + lastValue + "<br/>");
		}
		response.getWriter().append("使用getParameterMap方法来遍历获取所有参数信息,map遍历方式2<br/>");
		// map遍历方式2
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
		response.getWriter().append("使用getParameterMap方法来遍历获取所有参数信息,map遍历方式3<br/>");
		// map遍历方式3 弊端 只能拿到值，拿不到键
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
