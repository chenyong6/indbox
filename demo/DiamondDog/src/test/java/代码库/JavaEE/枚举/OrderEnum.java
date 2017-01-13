package 代码库.JavaEE.枚举;

import java.util.HashMap;
import java.util.Map;

public enum OrderEnum {
	STATUS_DEL(Type.STATUS, -1, "删除"),
	STATUS_NEW(Type.STATUS, 0, "新建"),
	STATUS_PENDING(Type.STATUS, 1, "待审核"),
	TYPE_ALARM(Type.TYPE, 1, "告警工单"),
	TYPE_COMMON(Type.TYPE, 2, "普通工单");
	
	private final int intVal;
	private final String strVal;
	
	private final Type type;
	/**
	 * 工单状态属性Map 
	 * 方便转Json 前台下拉框，和数据库int状态转中文时使用
	 */
	public static final Map<Integer, OrderEnum> statusMap = new HashMap<Integer, OrderEnum>();
	/**
	 * 工单类型属性Map
	 */
	public static final Map<Integer, OrderEnum> typeMap = new HashMap<Integer, OrderEnum>();
	static {
		for (OrderEnum oe : values()) {
			switch (oe.type) {
			case STATUS:
				statusMap.put(Integer.valueOf(oe.intVal), oe);
				break;
			case TYPE:
				typeMap.put(Integer.valueOf(oe.intVal), oe);
				break;
			default:
				break;
			}
		}
	}
	/**
	 * 用来规定属性类型。
	 * 比如 工单{
	 *    工单状态属性
	 *    工单类型
	 * }
	 */
	private enum Type {
		STATUS, TYPE;
	}

	OrderEnum(Type type, int intVal, String strVal) {
		this.type = type;
		this.intVal = intVal;
		this.strVal = strVal;
	}

	
	public int getIntVal() {
		return intVal;
	}

	public String getStrVal() {
		return strVal;
	}

	public Type getType() {
		return type;
	}

	public String toString() {
		return strVal;
	}
	public static void main(String[] args) {
		System.err.println(OrderEnum.statusMap.get(1));
		System.err.println(OrderEnum.statusMap);
		System.err.println(OrderEnum.statusMap.entrySet());
		System.err.println(OrderEnum.values());
		System.err.println( System.currentTimeMillis()+"  "+System.nanoTime());
	}
}
