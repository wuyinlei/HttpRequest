package com.yinlei;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletRequest4
 * 解决表单中文乱码问题
 */
@WebServlet("/Request4")
public class ServletRequest4 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 1、当提交方式是post的时候
		 * request.setCharacterEncoding("utf-8");
		 */
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("username");
		
		
		/**
		 * 2、当提交的方式是get方式
		 * 解决办法：
		 * 重建字符串   先拿到字符集，然后再去设置字符集(当控件较少的时候使用)
		 */
		name = new String(name.getBytes("ISO-8859-1"),"utf-8");
		
		//当写中文的控件较多的时候，更改服务器端的编码，在改端口号(server.xml)的地方该字符
		//URIEncoding = "utf-8"
		
		
		
		System.out.println(name);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
