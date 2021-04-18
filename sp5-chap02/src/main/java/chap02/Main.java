package chap02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(AppContext.class);
		Greeter g = ctx.getBean("greeter", Greeter.class);
		g.setFormat("%s. 화이팅!!!");
		String msg = g.greet("스프링 잘해보자");
		
		System.out.println(msg);
		
		Greeter f = ctx.getBean("greeter", Greeter.class);
		String msg2 = f.greet("민규야 잘해보자");
		
		System.out.println(msg2);
		
		System.out.println("(g == f) = " + (g == f));
		
		Greeter d = ctx.getBean("greeter2", Greeter.class);
		
		String msg3 = d.greet("한만돈");
		System.out.println(msg3);
		System.out.println("(g == d) = " + (g == d));
		
		
		
		ctx.close();

	}

}
