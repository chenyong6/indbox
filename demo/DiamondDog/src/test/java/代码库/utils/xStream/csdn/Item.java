package 代码库.utils.xStream.csdn;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("item")
public class Item {
	private int ids;
	private String names;
	private int ages;
	
	public Item(int ids,String names,int ages){
		this.ids = ids;
		this.names = names;
		this.ages = ages;
	}
	
	public int getIds() {
		return ids;
	}
	public void setIds(int ids) {
		this.ids = ids;
	}
	public String getNames() {
		return names;
	}
	public void setNames(String names) {
		this.names = names;
	}
	public int getAges() {
		return ages;
	}
	public void setAges(int ages) {
		this.ages = ages;
	}

}
