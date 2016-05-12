package com.yinlei;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletRequest1 ��ʾrequest�ĳ��÷���
 */
@WebServlet("/Request1")
public class ServletRequest1 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");

		// ���÷���
		String url = request.getRequestURL().toString(); // �õ�Э��+��������ַ+�˿ں� +
															// �������� + ��Դ��ַ +
															// ����(�оͼ�)

		String uri = request.getRequestURI(); // ������+��Դ·��

		String contextPath = request.getContextPath(); // ��������

		String encoding = request.getCharacterEncoding(); // ����

		String localAddr = request.getLocalAddr(); // ��������ip��ַ

		int localPort = request.getLocalPort(); // �������Ķ˿ں�

		String remoteIp = request.getRemoteAddr(); // �ͻ��˵�ip

		int remotePort = request.getRemotePort(); // �ͻ��˵Ķ˿�

		String queryString = request.getQueryString(); // �������

		String method = request.getMethod(); // ���󷽷�

		PrintWriter out = response.getWriter();

		out.write("url : " + url + "<br>");
		out.write("uri : " + uri + "<br>");
		out.write("��������contextPath : " + contextPath + "<br>");
		out.write("����encoding : " + encoding + "<br>");
		out.write("������ip��ַlocalAddr : " + localAddr + "<br>");
		out.write("�������˿ں�localPort : " + localPort + "<br>");
		out.write("localAddr : " + localAddr + "<br>");
		out.write("�����ip��ַremoteIp : " + remoteIp + "<br>");
		out.write("����˿ں�remotePort : " + remotePort + "<br>");
		out.write("�������queryString : " + queryString + "<br>");
		out.write("����ʽmethod : " + method + "<br>");
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
