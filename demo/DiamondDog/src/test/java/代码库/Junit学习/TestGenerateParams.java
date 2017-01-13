package 代码库.Junit学习;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestGenerateParams
{
	
	private String greeting;
	
	public TestGenerateParams(String greeting)
	{
		super();
		this.greeting = greeting;
	}

	@Test
	public void testParams()
	{
		System.out.println(greeting);
	}
	
	/**
	 * 这里的返回至少是二维数组
	 * @return
	 */
	@Parameters
	public static List<String[]> getParams()
	{
		return 
				Arrays.asList(new String[][]{{"hello"}, 
						{"hi"}, 
						{"good morning"},
						{"how are you"}});
	}
}