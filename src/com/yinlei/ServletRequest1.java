package com.yinlei;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletRequest1 演示request的常用方法
 */
@WebServlet("/Request1")
public class ServletRequest1 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");

		// 常用方法
		String url = request.getRequestURL().toString(); // 拿到协议+服务器地址+端口号 +
															// 工程名称 + 资源地址 +
															// 参数(有就加)

		String uri = request.getRequestURI(); // 工程名+资源路径

		String contextPath = request.getContextPath(); // 工程名称

		String encoding = request.getCharacterEncoding(); // 编码

		String localAddr = request.getLocalAddr(); // 服务器的ip地址

		int localPort = request.getLocalPort(); // 服务器的端口号

		String remoteIp = request.getRemoteAddr(); // 客户端的ip

		int remotePort = request.getRemotePort(); // 客户端的端口

		String queryString = request.getQueryString(); // 请求参数

		String method = request.getMethod(); // 请求方法

		PrintWriter out = response.getWriter();

		out.write("url : " + url + "<br>");
		out.write("uri : " + uri + "<br>");
		out.write("工程名称contextPath : " + contextPath + "<br>");
		out.write("编码encoding : " + encoding + "<br>");
		out.write("服务器ip地址localAddr : " + localAddr + "<br>");
		out.write("服务器端口号localPort : " + localPort + "<br>");
		out.write("localAddr : " + localAddr + "<br>");
		out.write("请求端ip地址remoteIp : " + remoteIp + "<br>");
		out.write("请求端口号remotePort : " + remotePort + "<br>");
		out.write("请求参数queryString : " + queryString + "<br>");
		out.write("请求方式method : " + method + "<br>");
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
