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


//演示获取表单提交的信息
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

	// 1.获取单个控件的值 eg:获取姓名
	public void test1(HttpServletRequest request) {
		//当表单中没有填写内容的时候，服务器端拿到的是""空字符串
		//当表单中没有这个参数的id的时候，拿到的是null
		String name = request.getParameter("username"); // 参数是控件的名字
		System.out.println("姓名： " + name);
	}

	// 2.获取同名控件的值 eg:获取密码
	public void test2(HttpServletRequest request) {

		String[] pass = request.getParameterValues("password");
		for (String string : pass) {
			System.out.println(string);
		}
	}

	// 3.获取所有控件的名字和值
	public void test3(HttpServletRequest request) {
		// 获取所有控件的名字
		Enumeration<String> enu = request.getParameterNames();
		while (enu.hasMoreElements()) {
			String name = enu.nextElement();
			// 由于名字可能会重复
			String[] values = request.getParameterValues(name);
			for (String value : values) {
				System.out.println(name + ":" + value);
			}
		}
	}

	// 4.将表单中的所有值封装到Javabean中： 采用PropertyDesceipt
	public void test4(HttpServletRequest request) {
		// 将页面传递的内容封装到user对象中
		User user = new User();
		System.out.println("封装前： " + user);
		// 获取所有控件的名字
		Enumeration<String> enu = request.getParameterNames();
		while (enu.hasMoreElements()) {
			String name = enu.nextElement();
			// 由于名字可能会重复
			String[] values = request.getParameterValues(name);

			try {
				// 拿到属性name的属性描述器
				PropertyDescriptor pd = new PropertyDescriptor(name, User.class);
				// 将值注入到属性中
				// 拿到写描述器
				Method method = pd.getWriteMethod();
				// 为了兼容jdk1.4，sun开发的invoke方法在执行的时候将参数拆开进行传递，所以导致IllegalArgumentException异常
				if (values.length == 1)
					method.invoke(user, values);
				else {
					// 解决办法一：
					// method.invoke(IllegalArgumentException:, (Object)values)
					// ;
					// 解决办法二
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

		System.out.println("封装后： " + user);
	}

	// 5.将表单中的所有值封装到Javabean中： 采用第三方的jar进行封装： BeanUtils类
	public void test5(HttpServletRequest request) {
		// 将页面传递的内容封装到user对象中
		User user = new User();
		System.out.println("封装前： " + user);
		// 获取所有控件的名字
		Enumeration<String> enu = request.getParameterNames();
		while (enu.hasMoreElements()) {
			String name = enu.nextElement();
			// 由于名字可能会重复
			String[] values = request.getParameterValues(name);

			// 采用BeanUtils类封装
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
		System.out.println("封装后： " + user);
	}

	// 6.将表单中的所有值封装到Javabean中： 采用第三方的jar进行封装： BeanUtils类
	public void test6(HttpServletRequest request) {
		// 将页面传递的内容封装到user对象中
		User user = new User();
		System.out.println("封装前： " + user);
		// 拿到控件的名字和值的键值对
		Map<String, String[]> map = request.getParameterMap();

		for (Map.Entry<String, String[]> entry : map.entrySet()) {
			// 拿到控件的名字
			String name = entry.getKey();
			// 拿到控件的值
			String[] values = entry.getValue();

			// 封装数据
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

		System.out.println("封装后： " + user);
	}

	// 7.终极必杀技
	public void test7(HttpServletRequest request) {
		// 将页面传递的内容封装到user对象中
		User user = new User();
		System.out.println("封装前： " + user);
		
		try {
			BeanUtils.populate(user, request.getParameterMap()) ;
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("封装后： " + user);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
