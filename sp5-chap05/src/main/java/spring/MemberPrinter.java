package spring;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;

public class MemberPrinter {
	
	private DateTimeFormatter dateTimeFormatter;
	
	public void print(Member member) {
		if(dateTimeFormatter == null)
		{
			System.out.printf("회원정보 : 아이디=%d, 이메일=%s, 이름=%s, 등록일=%tF\n",
					member.getId(), member.getEmail(), member.getName(), member.getRegisterDatetime());
		} else {
			System.out.printf("회원정보 : 아이디=%d, 이메일=%s, 이름=%s, 등록일=%s\n",
					member.getId(), member.getEmail(), member.getName(), dateTimeFormatter.format(member.getRegisterDatetime()));
		}
	}
	/*
	@Autowired(required = false)
	public void setDateTimeFormatter(DateTimeFormatter dateTimeFormatter)
	{
		this.dateTimeFormatter = dateTimeFormatter;
	}
	*/
	/*
	@Autowired
	public void setDateTimeFormatter(Optional<DateTimeFormatter> dateTimeFormatterOpt)
	{
		if(dateTimeFormatterOpt.isPresent())
		{
			this.dateTimeFormatter = dateTimeFormatterOpt.get();
		} else {
			this.dateTimeFormatter = null;
		}		
	}
	*/
	@Autowired
	public void setDateTimeFormatter(@Nullable DateTimeFormatter dateTimeFormatter)
	{
		this.dateTimeFormatter = dateTimeFormatter;
	}
	

}
