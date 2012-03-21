package com.haojii.spring.injection.setter_based;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Foo {
	private Bar bar;
	private Baz baz;

	public void setBar(Bar bar) {
		this.bar = bar;
	}

	public void setBaz(Baz baz) {
		this.baz = baz;
	}
	
	@Override
	public String toString() {
		return "Foo [bar=" + bar + ", baz=" + baz + "]";
	}

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/haojii/spring/injection/setter_based/setter_based_demo1.xml");

		Foo foo1 = context.getBean("foo1", Foo.class);

		System.out.println(foo1.toString());
	}
}
