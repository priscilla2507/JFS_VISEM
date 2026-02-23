	package com.example.main;

	import org.springframework.context.ApplicationContext;
	import org.springframework.context.support.ClassPathXmlApplicationContext;

	public class App {
		public static void main(String[] args) {

			ApplicationContext context =
					new ClassPathXmlApplicationContext("applicationContext.xml");

			HelloWorld obj = (HelloWorld) context.getBean("hello");
			obj.sayHello();
		}
	}