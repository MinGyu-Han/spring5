package chap07;

import org.springframework.stereotype.Component;

public class RecCalculator implements Calculator {

	@Override
	public long factorial(long num) {
		if(num == 0) return 1;
		return factorial(num-1)*num;
	}

}
