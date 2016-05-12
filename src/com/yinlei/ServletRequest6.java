package com.yinlei;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletRequest6
 * <p>
 * request对象作为一个域对象使用
 * </P>
 */
@WebServlet("/Request6")
public class ServletRequest6 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("name", "杨过");
		System.out.println("你过来了");
		/**
		 * request的请求转发和ServletContext对象请求转发的区别
		 * 
		 * request的请求转发请求的路径支持相对路径 ServletContext的请求转发不支持相对路径
		 */
		// 请求转发器
		// RequestDispatcher rd = request.getRequestDispatcher("/Request7");
		RequestDispatcher rd = request.getRequestDispatcher("Request7");
		// 转发到/HttpRequest/Resquest7
		//rd.forward(request, response);
		
		
		//请求包含
		rd.include(request, response);//把Request7包含进来
		
		//拿取数据(如果是包含的话，我就可以拿到我所包含的里面存储的数据)
		int age =  (int) request.getAttribute("age");
		System.out.println(age);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
