package _inbox.集合;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.junit.Test;


public class Iterator与ListIterator区别 {
	java.util.Random random = new java.util.Random(10L);
	@Test
	public void iterator(){
		List<User> list = new ArrayList<User>();
		
		list.add(new User());
		list.add(new User());
		list.add(new User());
		
		Iterator<User> userIte = list.iterator();
		while(userIte.hasNext()){
			User user = userIte.next();
			user.id = random.nextInt(10);
			System.err.println("--1--"+user);
		}
	}
	@Test
	public void listIterator(){
		
		List<User> list = new ArrayList<User>();
		
		list.add(new User());
		list.add(new User());
		list.add(new User());
		
		ListIterator<User> userIte = list.listIterator();
		while(userIte.hasNext()){
			User user = userIte.next();
			user.id = random.nextInt(10);
			System.err.println("--2--"+user);
		}
	}
	class User{
		public int id = 0;
		
		public String name = "zs";

		@Override
		public String toString() {
			return "User [id=" + id + ", name=" + name + "]";
		}
		
		}
}
