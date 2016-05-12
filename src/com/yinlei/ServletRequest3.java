package com.yinlei;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.yinlei.bean.User;


//��ʾ��ȡ���ύ����Ϣ
@WebServlet(urlPatterns="/Request3",initParams={@WebInitParam(name="hello",value="zhagnsan")})
public class ServletRequest3 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		String encoding = request.getCharacterEncoding() ;
//		System.out.println(encoding);
	
		
		 //test1(request);
		// test2(request);
		// test3(request);
		 //test4(request);
		// test5(request);
		//test6(request);
		//test7(request);
	}

	// 1.��ȡ�����ؼ���ֵ eg:��ȡ����
	public void test1(HttpServletRequest request) {
		//������û����д���ݵ�ʱ�򣬷��������õ�����""���ַ���
		//������û�����������id��ʱ���õ�����null
		String name = request.getParameter("username"); // �����ǿؼ�������
		System.out.println("������ " + name);
	}

	// 2.��ȡͬ���ؼ���ֵ eg:��ȡ����
	public void test2(HttpServletRequest request) {

		String[] pass = request.getParameterValues("password");
		for (String string : pass) {
			System.out.println(string);
		}
	}

	// 3.��ȡ���пؼ������ֺ�ֵ
	public void test3(HttpServletRequest request) {
		// ��ȡ���пؼ�������
		Enumeration<String> enu = request.getParameterNames();
		while (enu.hasMoreElements()) {
			String name = enu.nextElement();
			// �������ֿ��ܻ��ظ�
			String[] values = request.getParameterValues(name);
			for (String value : values) {
				System.out.println(name + ":" + value);
			}
		}
	}

	// 4.�����е�����ֵ��װ��Javabean�У� ����PropertyDesceipt
	public void test4(HttpServletRequest request) {
		// ��ҳ�洫�ݵ����ݷ�װ��user������
		User user = new User();
		System.out.println("��װǰ�� " + user);
		// ��ȡ���пؼ�������
		Enumeration<String> enu = request.getParameterNames();
		while (enu.hasMoreElements()) {
			String name = enu.nextElement();
			// �������ֿ��ܻ��ظ�
			String[] values = request.getParameterValues(name);

			try {
				// �õ�����name������������
				PropertyDescriptor pd = new PropertyDescriptor(name, User.class);
				// ��ֵע�뵽������
				// �õ�д������
				Method method = pd.getWriteMethod();
				// Ϊ�˼���jdk1.4��sun������invoke������ִ�е�ʱ�򽫲����𿪽��д��ݣ����Ե���IllegalArgumentException�쳣
				if (values.length == 1)
					method.invoke(user, values);
				else {
					// ����취һ��
					// method.invoke(IllegalArgumentException:, (Object)values)
					// ;
					// ����취��
					method.invoke(user, new Object[] { values });
				}

			} catch (IntrospectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		System.out.println("��װ�� " + user);
	}

	// 5.�����е�����ֵ��װ��Javabean�У� ���õ�������jar���з�װ�� BeanUtils��
	public void test5(HttpServletRequest request) {
		// ��ҳ�洫�ݵ����ݷ�װ��user������
		User user = new User();
		System.out.println("��װǰ�� " + user);
		// ��ȡ���пؼ�������
		Enumeration<String> enu = request.getParameterNames();
		while (enu.hasMoreElements()) {
			String name = enu.nextElement();
			// �������ֿ��ܻ��ظ�
			String[] values = request.getParameterValues(name);

			// ����BeanUtils���װ
			try {
				BeanUtils.setProperty(user, name, values);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("��װ�� " + user);
	}

	// 6.�����е�����ֵ��װ��Javabean�У� ���õ�������jar���з�װ�� BeanUtils��
	public void test6(HttpServletRequest request) {
		// ��ҳ�洫�ݵ����ݷ�װ��user������
		User user = new User();
		System.out.println("��װǰ�� " + user);
		// �õ��ؼ������ֺ�ֵ�ļ�ֵ��
		Map<String, String[]> map = request.getParameterMap();

		for (Map.Entry<String, String[]> entry : map.entrySet()) {
			// �õ��ؼ�������
			String name = entry.getKey();
			// �õ��ؼ���ֵ
			String[] values = entry.getValue();

			// ��װ����
			try {
				BeanUtils.setProperty(user, name, values);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println("��װ�� " + user);
	}

	// 7.�ռ���ɱ��
	public void test7(HttpServletRequest request) {
		// ��ҳ�洫�ݵ����ݷ�װ��user������
		User user = new User();
		System.out.println("��װǰ�� " + user);
		
		try {
			BeanUtils.populate(user, request.getParameterMap()) ;
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("��װ�� " + user);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
