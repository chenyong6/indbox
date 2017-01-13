package 代码库.JavaEE.反射.对象拷贝.domain;

public class LackOfSetter {
	private int id;
	private String name;

	public LackOfSetter() {
	}

	public LackOfSetter(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public int getId() {
		
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "LackOfSetter [id=" + id + ", name=" + name + "]";
	}
	
}
