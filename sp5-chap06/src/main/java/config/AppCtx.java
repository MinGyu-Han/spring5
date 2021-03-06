package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import spring.ChangePasswordService;
import spring.Client;
import spring.Client2;
import spring.MemberRegisterService;
import spring.VersionPrinter;
import spring.MemberListPrinter;
import spring.MemberPrinter;
import spring.MemberDao;
import spring.MemberInfoPrinter;

@Configuration
public class AppCtx {
	@Bean
	@Scope("singleton")
	public Client client() {
		Client client = new Client();
		client.setHost("host");
		return client;
	}
	@Bean(initMethod = "connect", destroyMethod = "close")
	public Client2 client2() {
		Client2 client = new Client2();
		client.setHost("host");
		return client;
	}
}

