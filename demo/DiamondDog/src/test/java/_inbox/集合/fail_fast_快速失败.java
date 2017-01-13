package _inbox.集合;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;

public class fail_fast_快速失败 {
	public static void main(String[] args) {
		List<User> list = new ArrayList<User>();
		fail_fast_快速失败 fail_fast_快速失败 = new fail_fast_快速失败();
		list.add(fail_fast_快速失败.new User());
		list.add(fail_fast_快速失败.new User());
		list.add(fail_fast_快速失败.new User());
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0;i<Integer.MAX_VALUE;i++){
					System.err.println("rm--");
					list.remove(0);
				}
			}
		}).start();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0;i<Integer.MAX_VALUE;i++){
					list.add(fail_fast_快速失败.new User());
					System.err.println("add--"+list.size());
				}
			}
		}).start();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0;i<Integer.MAX_VALUE;i++){
					Iterator<User> userIte = list.iterator();
					System.err.println("list--");
					while(userIte.hasNext()){
						User user = userIte.next();
					}
				}
			}
		}).start();
		//Executors.newCachedThreadPool();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0;i<Integer.MAX_VALUE;i++){
					System.err.println("rm--");
					list.remove(0);
				}
			}
		}).start();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0;i<Integer.MAX_VALUE;i++){
					System.err.println("rm--");
					list.remove(0);
				}
			}
		}).start();
		
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
