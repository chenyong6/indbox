package 代码库.缓存.Redis.发布订阅.X;

import redis.clients.jedis.Jedis;

/**
 * jedis控制器
 * @author 吕桂强
 * @email larry.lv.word@gmail.com
 * @version 创建时间：2012-3-28 下午12:03:40
 */
public final class jedis_control {
	//单例
	private static jedis_control _jedis_control;
	public static jedis_control get_singleton(){
		if(_jedis_control == null){
			_jedis_control = new jedis_control();
		}
		return _jedis_control;
	}
	
	/**      
	 * 获取连接实例       
	 * @return jedis       
	 */     
	public Jedis get_connection() {
		Jedis jedis = null;          
		try {              
			jedis = singleton_agent.get_jedispool().getResource();          
		} catch (Exception e) {              
			e.printStackTrace();          
		}          
		return jedis;      
	}   
	
	/**       
	 * 释放数据库连接       
	 * @param conn       
	 */     
	public void close_connection(Jedis jedis) {          
		if (null != jedis) {              
			try {                  
				singleton_agent.get_jedispool().returnResource(jedis);              
			} catch (Exception e) {
					e.printStackTrace();              
			}          
		}      
	}  
} 
