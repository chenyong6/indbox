package 代码库.缓存.Redis.发布订阅.X;

import redis.clients.jedis.Jedis;

/**
 * 入口类
 * @author 吕桂强
 * @email larry.lv.word@gmail.com
 * @version 创建时间：2012-3-28 下午12:12:41
 */
public class jedis_demo {
	jedis_control redis_util = jedis_control.get_singleton();
	
	public static void main(String[] args) {
		jedis_demo jedis_demo = new jedis_demo();
		
		new Thread(new Runnable(){
			@Override
			public void run() {
				jedis_control redis_util = jedis_control.get_singleton();
				Jedis jedis = redis_util.get_connection();
				jedis_pub_sub_listener pub_sub_listener = new jedis_pub_sub_listener();
				// 可以订阅多个频道
				// 订阅得到信息在lister的onMessage(...)方法中进行处理
				// jedis.subscribe(listener, "news.share", "news.log");
				// jedis.subscribe(listener, new String[]{"news.share","news.log"});
				jedis.psubscribe(pub_sub_listener, new String[] { "news.share" });// 使用模式匹配的方式设置频道
			}
		}).start();
		
		jedis_demo.publish();
	}

	/**
	 * 发布
	 */
	public void publish() {
		Jedis jedis = redis_util.get_connection();  
		jedis.publish("news.share", "ok");  
		jedis.publish("news.share", "hello word"); 
		jedis.publish("news.share", "hello word --"); 
	}
}
