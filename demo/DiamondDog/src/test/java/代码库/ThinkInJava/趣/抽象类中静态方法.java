package 代码库.ThinkInJava.趣;

import org.springframework.util.Assert;

//LocaleContextHolder
public class 抽象类中静态方法 {
	private static final ThreadLocal<String> localeContextHolder = new NamedThreadLocal<String>("");

	private static final ThreadLocal<String> inheritableLocaleContextHolder = new InheritableThreadLocal<String>();

	/**
	 * Reset the LocaleContext for the current thread.
	 */
	public static void resetLocaleContext() {
		localeContextHolder.remove();
		inheritableLocaleContextHolder.remove();
	}
}
 class NamedThreadLocal<T> extends ThreadLocal<T> {
	private final String name;
	/**
	 * Create a new NamedThreadLocal with the given name.
	 * @param name a descriptive name for this ThreadLocal
	 */
	public NamedThreadLocal(String name) {
		Assert.hasText(name, "Name must not be empty");
		this.name = name;
	}
	@Override
	public String toString() {
		return this.name;
	}
}