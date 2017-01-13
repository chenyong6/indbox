package _inbox;


import java.util.Calendar;

import org.junit.Test;

public class Test01 {
	@Test
	public void dd(){
		long sum = 0L;
		long time = Calendar.getInstance().getTimeInMillis();
		for(int i = 0;i<Integer.MAX_VALUE;i++){
			sum += i;
		}
		"ssss".substring(0,2);
		System.err.println( Calendar.getInstance().getTimeInMillis()-time );
		System.err.println(sum);
	}
	@Test
	public void ddd(){
		int channleNum = 100;
		int VQDNum = 3;
		double result = channleNum*1.0/VQDNum;
		System.err.println(result);
	}
}
