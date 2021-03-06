package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import controller.RegisterController;
import controller.SurveyController;
import spring.MemberRegisterService;

@Configuration
public class ControllerConfig {
	
	@Autowired
	private MemberRegisterService memberRegSvc;
	@Bean
	public RegisterController registerController() {
		RegisterController regController = new RegisterController();
		regController.setMemberRegisterService(memberRegSvc);
		return regController;
	}
	
	@Bean
	public SurveyController surveyController() {
		return new SurveyController();
	}

}
