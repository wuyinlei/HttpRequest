package com.yinlei;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletRequest2
 * ��ʾ����ͷ��Ϣ
 */
@WebServlet("/ServletRequest2")
public class ServletRequest2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ��������ͷ��Ϣ
		//String encoding = request.getHeader("Accept-Encoding");  //
		
		//��ȡͬ��������Ķ��ֵ
		/*Enumeration<String> enu = request.getHeaders("Accept-Encoding");
		while(enu.hasMoreElements()){
			String key = enu.nextElement();
			System.out.println(key);
		}*/
		
		//�õ����е�����ͷ��ֵ
		Enumeration<String> enu = request.getHeaderNames();
		while(enu.hasMoreElements()){
			System.out.println(enu.nextElement() + ":" + request.getHeader(enu.nextElement()));
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
