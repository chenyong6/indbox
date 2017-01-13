package 代码库.缓存.Redis.发布订阅;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import 代码库.缓存.Redis.RedisUtil;

public class Main {
	/**
	 * Jedis有两种订阅模式：subsribe(一般模式设置频道)和psubsribe(使用模式匹配来设置频道)。
	 * 不管是那种模式都可以设置个数不定的频道。
	 * 订阅得到信息在将会lister的onMessage(...)方法或者onPMessage(...)中进行进行处理.
	 * 
	 */
	public static void main(String[] args) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				final Jedis jedis = RedisUtil.getJedis();
				final JedisPubSubListener listener = new JedisPubSubListener();
				// 可以订阅多个频道
				// 订阅得到信息在lister的onMessage(...)方法中进行处理
				//jedis.subscribe(listener, "foo", "watson");
				// 也用数组的方式设置多个频道
				// jedis.subscribe(listener, new String[]{"hello_foo","hello_test"});
				// 这里启动了订阅监听，线程将在这里被阻塞
				// 订阅得到信息在lister的onPMessage(...)方法中进行处理
				jedis.psubscribe(listener, new String[] { "news.share" });
			}
		}).start();
		
		final Jedis jedisPub = RedisUtil.getJedis();
		jedisPub.publish("news.share", "xx");
	}
//	@Test
//	public  void publish(){
//		final Jedis jedisPub = RedisUtil.getJedis();
//		jedisPub.publish("news.share", "xx1");
//		jedisPub.publish("news.share", "xx");
//		RedisUtil.returnResource(jedisPub);
//	}
}