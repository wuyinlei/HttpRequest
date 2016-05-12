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
 * request������Ϊһ�������ʹ��
 * </P>
 */
@WebServlet("/Request6")
public class ServletRequest6 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("name", "���");
		System.out.println("�������");
		/**
		 * request������ת����ServletContext��������ת��������
		 * 
		 * request������ת�������·��֧�����·�� ServletContext������ת����֧�����·��
		 */
		// ����ת����
		// RequestDispatcher rd = request.getRequestDispatcher("/Request7");
		RequestDispatcher rd = request.getRequestDispatcher("Request7");
		// ת����/HttpRequest/Resquest7
		//rd.forward(request, response);
		
		
		//�������
		rd.include(request, response);//��Request7��������
		
		//��ȡ����(����ǰ����Ļ����ҾͿ����õ���������������洢������)
		int age =  (int) request.getAttribute("age");
		System.out.println(age);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
