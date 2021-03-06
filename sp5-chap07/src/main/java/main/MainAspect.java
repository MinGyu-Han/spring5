package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import chap07.Calculator;
import config.AppCtx;

public class MainAspect {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppCtx.class);
		Calculator calculator = ctx.getBean(Calculator.class);
		long fiveFact = calculator.factorial(5);
		System.out.println("cal.factorial(5) = " + fiveFact);
		System.out.println(calculator.getClass().getName());
		ctx.close();

	}

}
