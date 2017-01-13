package _inbox.集合;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayList_LinkedList {
	public static void main(String[] args) {
		List<String> arraylist = new ArrayList<String>();
		List<String> linkedlist = new LinkedList<String>();
		List<String> arraylistYL = new ArrayList<String>();
		for (int n = 0; n < 20000; n++) {
			arraylistYL.add(n, null);
		}
		for (int n = 0; n < 20000; n++) {
			arraylist.add(n, null); // 当在200000条数据之前插入20000条数据时，ArrayList用了18375多ms.时间花费是arraylist的近20倍(视测试时机器性能)
		}
		long time5 = System.nanoTime();
		System.out.print("batch arraylist add:");
		System.out.println("arrayList  : " + (System.nanoTime() - time5));
		for (int m = 0; m < 20000; m++) {
			linkedlist.add(m, null); // 当在200000条数据之前插入20000条数据时，LinkedList只用了1125多ms.这就是LinkedList的优势所在
		}

		long time4 = System.nanoTime();
		System.out.print("batch linkedlist add:");
		System.out.println("linkedlist :" + (System.nanoTime() - time4));
		
	}
}
