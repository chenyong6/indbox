package 代码库.缓存.Redis.发布订阅.X;

import redis.clients.jedis.JedisPubSub;

/**
 * 监听订阅事件
 * 
 * @author 吕桂强
 * @email larry.lv.word@gmail.com
 * @version 创建时间：2012-3-28 下午12:09:20
 */
public class jedis_pub_sub_listener extends JedisPubSub {
	// 取得订阅的消息后的处理
	public void onMessage(String channel, String message) {
		System.out.println("onMessage: " + channel + "=" + message);
	}

	// 初始化订阅时候的处理
	public void onSubscribe(String channel, int subscribedChannels) {
		System.out
				.println("onSubscribe: " + channel + "=" + subscribedChannels);
	}

	// 取消订阅时候的处理
	public void onUnsubscribe(String channel, int subscribedChannels) {
		System.out.println("onUnsubscribe: " + channel + "="
				+ subscribedChannels);
	}

	// 初始化按表达式的方式订阅时候的处理
	public void onPSubscribe(String pattern, int subscribedChannels) {
		System.out.println("onPSubscribe: " + pattern + "="
				+ subscribedChannels);
	}

	// 取消按表达式的方式订阅时候的处理
	public void onPUnsubscribe(String pattern, int subscribedChannels) {
		System.out.println("onPUnsubscribe: " + pattern + "="
				+ subscribedChannels);
	}

	// 取得按表达式的方式订阅的消息后的处理
	public void onPMessage(String pattern, String channel, String message) {
		System.out.println("onPMessage: " + pattern + "=" + channel + "="
				+ message);
	}
}
