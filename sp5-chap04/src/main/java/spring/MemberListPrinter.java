package spring;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MemberListPrinter {
	
	private MemberDao memberDao;
	private MemberPrinter memberPrinter;
	
	public MemberListPrinter()
	{
	}
	
	@Autowired
	public void setMemberDao(MemberDao memberDao)
	{
		this.memberDao = memberDao;
	}
	/*
	@Autowired
	@Qualifier("summaryPrinter")
	public void setMemberPrinter(MemberPrinter memberPrinter)
	{
		this.memberPrinter = memberPrinter;
	}
	*/
	@Autowired
	public void setMemberPrinter(MemberSummaryPrinter memberPrinter)
	{
		this.memberPrinter = memberPrinter;
	}
	
	public void printAll()
	{
		Collection<Member> members = memberDao.selectAll();
		members.forEach(m->memberPrinter.print(m));
	}

}
