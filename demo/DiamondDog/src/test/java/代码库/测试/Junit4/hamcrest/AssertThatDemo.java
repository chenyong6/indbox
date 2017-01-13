package 代码库.测试.Junit4.hamcrest;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.matchers.JUnitMatchers.*;

import org.junit.Test;
@SuppressWarnings("all")
public class AssertThatDemo {
	
	
	@Test
	public void assertThatTest(){
		assertThat(3,allOf(is(2)));
	}
	
	
	
	int getRandomFrom(int p, int r) {
		int chooes = r - p + 1;
		return (int) Math.floor(Math.random() * chooes + p);
	}

	@Test
	public void testGetRandomFrom() {
		for (int i = 0; i < 100; i++) {
			System.err.println(i);
			assertThat(
					getRandomFrom(4, 10),
					anyOf(equalTo(5), equalTo(6), equalTo(7), equalTo(8),
							equalTo(9), equalTo(10)));
		}
	}
}
