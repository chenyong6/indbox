package 代码库.JavaEE.动态代理.cglib;

public class Client {
	public static void main(String[] args) {

		BookServiceBean service = BookServiceFactory.getAuthInstanceByFilter(new MyCglibProxy("jhon"));
		service.create();
		BookServiceBean service2 = BookServiceFactory.getAuthInstanceByFilter(new MyCglibProxy("jhon"));
		service2.query();
		doMethod(service);
	}

	public static void doMethod(BookServiceBean service) {
		service.create();
		service.update();
		service.query();
		service.delete();
	}
}
