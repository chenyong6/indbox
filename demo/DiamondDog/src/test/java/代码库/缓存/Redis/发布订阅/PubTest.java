package 代码库.缓存.Redis.发布订阅;

import redis.clients.jedis.Jedis;
import 代码库.缓存.Redis.RedisUtil;

public class PubTest {
	public static void main(String[] args) {
		final Jedis jedis = RedisUtil.getJedis();
		jedis.publish("news.share", "dddd");
	}
}
