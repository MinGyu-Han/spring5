package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/*
import spring.MemberDao;
import spring.MemberPrinter;


@Configuration
@Import(AppCtx2.class)
public class AppConfImport {
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	@Bean
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}

}
*/

@Configuration
@Import({AppCtx1.class, AppCtx2.class})
public class AppConfImport {
}
