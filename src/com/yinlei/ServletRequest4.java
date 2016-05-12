package com.yinlei;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletRequest4
 * �����������������
 */
@WebServlet("/Request4")
public class ServletRequest4 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 1�����ύ��ʽ��post��ʱ��
		 * request.setCharacterEncoding("utf-8");
		 */
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("username");
		
		
		/**
		 * 2�����ύ�ķ�ʽ��get��ʽ
		 * ����취��
		 * �ؽ��ַ���   ���õ��ַ�����Ȼ����ȥ�����ַ���(���ؼ����ٵ�ʱ��ʹ��)
		 */
		name = new String(name.getBytes("ISO-8859-1"),"utf-8");
		
		//��д���ĵĿؼ��϶��ʱ�򣬸��ķ������˵ı��룬�ڸĶ˿ں�(server.xml)�ĵط����ַ�
		//URIEncoding = "utf-8"
		
		
		
		System.out.println(name);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
