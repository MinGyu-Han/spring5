package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import chap07.ExeTimeCalculator;
import chap07.ImpeCalculator;
import config.AppCtx;

public class MainProxy {
	
	private static ApplicationContext ctx = null;

	public static void main(String[] args) {
		
		ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		
		ExeTimeCalculator ttCal1 = ctx.getBean(ExeTimeCalculator.class);
		System.out.println(ttCal1.factorial(20));
		
		ttCal1.setDelegate(new ImpeCalculator());
		System.out.println(ttCal1.factorial(20));
		
		
	}

}
