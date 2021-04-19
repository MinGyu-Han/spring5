package spring;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberInfoPrinter {
	
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private MemberPrinter memberPrinter;
	
	public void printMemberInfo(String email)
	{
		Member member = memberDao.selectByEmail(email);
		if(member == null) 
		{
			System.out.println("일치하는 이메일이 없습니다.");
			return;
		}
		memberPrinter.print(member);
		System.out.println();
	}
	
	public void setMemberDao(MemberDao memberDao)
	{
		this.memberDao = memberDao;
	}
	public void setMemberPrinter(MemberPrinter memberPrinter)
	{
		this.memberPrinter = memberPrinter;
	}

}
