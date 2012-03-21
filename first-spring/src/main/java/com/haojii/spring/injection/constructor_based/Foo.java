package com.haojii.spring.injection.constructor_based;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Foo {
	private Bar bar;
	private Baz baz;
	
	public Foo(Bar bar, Baz baz) {
		this.bar = bar;
		this.baz = baz;
	}
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/haojii/spring/injection/constructor_based/constructor_based_demo1.xml");
		
		Foo foo1 = context.getBean("foo1", Foo.class);
		
		System.out.println(foo1.toString());
	}
}
