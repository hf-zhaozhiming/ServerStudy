package cn.response;
/*
 * 使用Content-Disposition 实现资源的下载
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseDemo3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		File file = new File("d:/mm.jpg");
		// 通过修改content-disposition头来实现资源的下载方式
		response.setHeader("content-disposition", "attachment;filename=" + file.getName());

		FileInputStream fis = new FileInputStream(file);
		ServletOutputStream outputStream = response.getOutputStream();

		byte[] buf = new byte[1024];
		int len = 0;
		while ((len = fis.read(buf)) != -1) {
			outputStream.write(buf, 0, len);
		}
		fis.close();
		outputStream.close();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
