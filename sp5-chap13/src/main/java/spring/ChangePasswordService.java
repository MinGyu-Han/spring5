package spring;

import org.springframework.transaction.annotation.Transactional;

public class ChangePasswordService {
	private MemberDao memberDao;
	
	@Transactional
	public void changePassword(String email, String oldPassowrd, String newPassword) 
	{
		Member member = memberDao.selectByEmail(email);
		if(member == null) throw new MemberNotFoundException();
		
		member.changePassword(oldPassowrd, newPassword);
		
		memberDao.update(member);
	}
	
	public void setMemberDao(MemberDao memberDao) 
	{
		this.memberDao = memberDao;
	}

}
