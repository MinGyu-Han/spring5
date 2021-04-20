package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppCtx;
import config.AppCtxWithExclude;
import spring.*;

public class MainForSpring {
	
	private static ApplicationContext ctx = null;

	public static void main(String[] args) throws IOException {
		
		ctx = new AnnotationConfigApplicationContext(AppCtxWithExclude.class);
		//ctx = new AnnotationConfigApplicationContext(AppCtx1.class, AppCtx2.class);
		//ctx = new AnnotationConfigApplicationContext(AppConfImport.class);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		while(true)
		{
			System.out.println("명령어를 입력하세요:");
			String command = reader.readLine();
			if(command.equalsIgnoreCase("exit")) 
			{
				System.out.println("종료합니다.");
				break;
			}
			if(command.startsWith("new ")) {
				processNewCommand(command.split(" "));
				continue;
			} else if(command.startsWith("change ")) {
				processChangeCommand(command.split(" "));
				continue;
			} else if(command.equals("list"))
			{
				processListCommand();
				continue;
			} else if(command.startsWith("info "))
			{
				processInfoCommand(command.split(" "));
				continue;
			} else if(command.equals("version"))
			{
				processVeresionCommand();
				continue;
			}
			printHelp();
		}
	}
	private static void processNewCommand(String[] arg)
	{
		if(arg.length != 5)
		{
			printHelp();
			return;
		}
		RegisterRequest reg = new RegisterRequest();
		reg.setEmail(arg[1]);
		reg.setName(arg[2]);
		reg.setPassword(arg[3]);
		reg.setConfirmPassword(arg[4]);
		
		if(!reg.isPasswordEqualToConfirmPassword())
		{
			System.out.println("암호와 확인이 일치하지 않습니다.");
			return;
		}
		
		MemberRegisterService regSvc = ctx.getBean(MemberRegisterService.class);
		try {
			regSvc.regist(reg);
			System.out.println("등록했습니다.\n");
		} catch (DuplicateMemberException e)
		{
			System.out.println("이미 존재하는 이메일입니다.\n");
		}
	}
	private static void processChangeCommand(String[] arg)
	{
		if(arg.length != 4)
		{
			printHelp();
			return;
		}
		ChangePasswordService pwdSvc = ctx.getBean(ChangePasswordService.class);
		try {
			pwdSvc.changePassword(arg[1], arg[2], arg[3]);
			System.out.println("암호를 변경했습니다.\n");		
		} catch(MemberNotFoundException e)
		{
			System.out.println("존재하지 않는 이메일입니다.\n");
		} catch(WrongIdPasswordException e)
		{
			System.out.println("이메일과 암호가 일치하지 않습니다.\n");
		}
		
	}
	private static void processListCommand()
	{
		MemberListPrinter listPrinter = ctx.getBean("listPrinter", MemberListPrinter.class);
		listPrinter.printAll();
	}
	
	private static void processInfoCommand(String[] arg)
	{
		if(arg.length != 2) 
		{
			printHelp();
			return;
		}
		MemberInfoPrinter infoPrinter = ctx.getBean("infoPrinter", MemberInfoPrinter.class);
		infoPrinter.printMemberInfo(arg[1]);
	}
	
	private static void processVeresionCommand()
	{
		VersionPrinter versionPrinter = ctx.getBean("versionPrinter", VersionPrinter.class);
		versionPrinter.print();
	}
	private static void printHelp()
	{
		System.out.println();
		System.out.println("잘못된 명령입니다. 아래 명령어 사용법을 확인하세요.");
		System.out.println("명령어 사용법 : ");
		System.out.println("new 이메일 이름 암호 암호확인");
		System.out.println("change 이메일 현재비번 변경비번");
		System.out.println("list");
		System.out.println("info 이메일");
		System.out.println("version");
		System.out.println();
	}

}
