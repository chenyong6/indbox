package 代码库.缓存.Redis;

import redis.clients.jedis.Jedis;

public class GetResourceTest {
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					for (;;) {
						getJedisTest();
					}
				}
			}).start();
		}
		

	}

	public static void getJedisTest() {
		Jedis jedis = RedisUtil.getJedis();
		jedis.set("test", "test");
		System.err.println("-->return jedis");
		RedisUtil.returnResource(jedis);
	}
}
