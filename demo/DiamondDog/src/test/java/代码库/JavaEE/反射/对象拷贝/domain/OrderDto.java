package 代码库.JavaEE.反射.对象拷贝.domain;

public class OrderDto {
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "OrderDto [id=" + id + ", name=" + name + "]";
	}
	
}
