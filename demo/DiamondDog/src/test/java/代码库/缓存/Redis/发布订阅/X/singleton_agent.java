package 代码库.缓存.Redis.发布订阅.X;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 所有单例的代理类
 * @author 吕桂强
 * @email larry.lv.word@gmail.com
 * @version 创建时间：2012-3-28 下午12:30:42
 */
public class singleton_agent {
	//****************单例一个连接池***************
	private static JedisPool jedispool = null;
	/**       
	 * 获取连接池       
	 * @return 数据源       
	 */     
	public static JedisPool get_jedispool() {
		if(jedispool == null){
			JedisPoolConfig jedispool_config = new JedisPoolConfig();
			jedispool_config.maxActive = 20;
			jedispool_config.maxIdle = 0;
			jedispool_config.maxWait = 1000;
			jedispool_config.testOnBorrow = true;
			jedispool = new JedisPool(jedispool_config, "localhost", 6379);
		}
		return jedispool;     
	}
	//end****************单例一个连接池***************
}
