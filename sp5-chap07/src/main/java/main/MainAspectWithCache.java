package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import chap07.Calculator;
import config.AppCtx;
import config.AppCtxWithCache;

public class MainAspectWithCache {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppCtxWithCache.class);
		Calculator calculator = ctx.getBean(Calculator.class);
		calculator.factorial(7);
		calculator.factorial(7);
		calculator.factorial(5);
		calculator.factorial(5);
		ctx.close();

	}

}
