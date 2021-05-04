package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import controller.ApiExceptionAdvice;
import controller.ChangePwdController;
import controller.LoginController;
import controller.LogoutController;
import controller.MemberDetailController;
import controller.MemberListContoller;
import controller.RegisterController;
import controller.RestMemberController;
import controller.SurveyController;
import spring.AuthService;
import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberRegisterService;

@Configuration
public class ControllerConfig {
	
	@Autowired
	private MemberRegisterService memberRegSvc;
	
	@Autowired
	private AuthService authService;
	
	@Autowired
	private ChangePasswordService changePasswordService;
	
	@Autowired
	private MemberDao memberDao;
	
	
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
	
	@Bean
	public LoginController loginController() {
		LoginController loginController = new LoginController();
		loginController.setAuthService(authService);
		return loginController;
	}
	
	@Bean
	public LogoutController logoutController() {
		return new LogoutController(); 
	}
	
	@Bean
	public ChangePwdController changePwdController() {
		ChangePwdController changePwdController = new ChangePwdController();
		changePwdController.setChangePasswordService(changePasswordService);
		return changePwdController;
	}
	
	@Bean
	public MemberListContoller memberListContoller() {
		MemberListContoller memberListContoller = new MemberListContoller();
		memberListContoller.setMemberDao(memberDao);
		return memberListContoller;
	}
	
	@Bean
	public MemberDetailController memberDetailContoller() {
		MemberDetailController memberDetailController = new MemberDetailController();
		memberDetailController.setMemberDao(memberDao);
		return memberDetailController;
	}
	
	@Bean
	public RestMemberController restMemberController() {
		return new RestMemberController();
	}
	
	@Bean
	public ApiExceptionAdvice apiExceptionAdvice() {
		return new ApiExceptionAdvice();
	}
}
