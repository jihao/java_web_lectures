package com.haojii.spring.injection.setter_based.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Foo {
	private Bar bar;
	private Baz baz;

	@Autowired
	public void setBar(Bar bar) {
		this.bar = bar;
	}
	
	@Autowired
	public void setBaz(Baz baz) {
		this.baz = baz;
	}
	
	@Override
	public String toString() {
		return "Foo [bar=" + bar + ", baz=" + baz + "]";
	}

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/haojii/spring/injection/setter_based/annotation/setter_based_demo2.xml");

		Foo foo1 = context.getBean(Foo.class);

		System.out.println(foo1.toString());
	}
}
