package 代码库.JavaEE.反射.对象拷贝.domain;

public class PropWithDiffType {
	private Integer id;
	private String name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
		return "PropWithDiffType [id=" + id + ", name=" + name + "]";
	}
	
}
