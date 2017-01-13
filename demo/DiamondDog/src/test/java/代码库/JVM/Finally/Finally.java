package 代码库.JVM.Finally;

public class Finally {
	public static void main(String[] args) {
		
		System.err.println(Finally.testInt(1));
		System.err.println(Finally.testObject(new User()));
	}
	public static int testInt(int a){
		//return之后执行finally方法块对，a值不变
		try{
			a = 1/0;
			return a;
		}catch(Exception e){
			a = 3;
			return a;
		}
		finally{
			a = 4;
			System.err.println("finally:"+a);
		}
		
	}
	public static User testObject(User user){
		//return之后执行finally方法块对，user引用不变
		//return 在finally 之前，则会先保留参数对于引用
		try{
			user.name = "cy";
			return user;
		}catch(Exception e){
			user.name = "cy e";
			return user;
		}
		finally{
			user = new User();
			user.name = "cy finally";
			System.err.println("finally:"+user);
		}
		
		
	}
	
	
	
	static class User{
		public String name;
		public int age;
		@Override
		public String toString() {
			return "User [name=" + name + ", age=" + age + "]";
		}
		
	}
	
}
