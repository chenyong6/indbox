package 代码库.JavaEE.Java7新特性;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

public class JAVA7新特性 {
	@Test
	public void testList() {
		new Thread(() -> System.out.println("这是一个java8的小例子,可以使用lambda表达式")).start();
	}
	@Test
	public void newTry() {

		try (FileOutputStream fos = new FileOutputStream("movies.txt");

				DataOutputStream dos = new DataOutputStream(fos)) {

			dos.writeUTF("Java 7 Block Buster");

		} catch (IOException e) {
			// log the exception
		}

	}

}
