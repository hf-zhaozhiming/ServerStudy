package cn.servlet;

/*
 * 获取个get 及 post 方法提交的参数信息
 */
import java.io.IOException;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestPara
 */
public class RequestPara extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		String queryString = request.getQueryString();
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath() + "<br/>");
		response.getWriter().append("doGet获取到来自网址：" + request.getHeader("referer") + "的参数信息为：")
				.append(queryString + "<br/>");
		getParameter(request, response);
	}

	private void getParameter(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.getWriter().append("<hr/>");
		// 使用getParameter方法 获取指定参数名称的参数值
		response.getWriter().append("使用getParameter方法来获取指定参数信息<br/>");
		String paraValue = request.getParameter("name");
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
		response.setContentType("text/html;charset=utf-8");
		ServletInputStream inputStream = request.getInputStream();
		byte[] buf = new byte[1024];
		int len = 0;
		while ((len = inputStream.read(buf)) != -1) {
			response.getWriter().append("doPost获取到来自网址：" + request.getHeader("referer") + "的参数信息为：")
					.append(new String(buf, 0, len) + "<br/>");
		}
		response.getWriter().append("name:").append(request.getParameter("name"));
		// 使用getParameter方法 获取指定参数名称的参数值
		response.getWriter().append("使用getParameter方法来获取指定参数信息<br/>");
		String paraValue = request.getParameter("name");
		response.getWriter().append("getParameter name :" + paraValue + "<br/>");
		response.getWriter().append("<hr/>");

		//
		// String[] parameterValues = request.getParameterValues("name");
		// String nameValues = "";
		// for (String s : parameterValues) {
		// nameValues = nameValues + "," + s;
		// }
		// response.getWriter().append("getParameterValues name :" + nameValues
		// + "<br/>");
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

}
