package chap07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ExeTimeCalculator implements Calculator {
	
	@Autowired
	@Qualifier("recCalculator")
	private Calculator delegate;
	
	@Override
	public long factorial(long num)
	{
		long start = System.nanoTime();
		long result = delegate.factorial(num);
		long end = System.nanoTime();
		System.out.printf("%s.factorial(%d) 실행시간 = %d\n", delegate.getClass().getSimpleName(), num, (end-start));
		return result;
	}
	
	public void setDelegate(Calculator delegate)
	{
		this.delegate = delegate;
	}

}
