package 代码库.缓存.Redis.事务;

import org.junit.Test;

public class RedisTransaction {
	@Test
	public void redisTran(){
		//Redis Multi 命令用于标记一个事务块的开始。
		//事务块内的多条命令会按照先后顺序被放进一个队列当中，最后由 EXEC 命令原子性(atomic)地执行。
		
		//Redis Watch 命令用于监视一个(或多个) key ，如果在事务执行之前这个(或这些) key 被其他命令所改动，那么事务将被打断
		
		//Redis Unwatch 命令用于取消 WATCH 命令对所有 key 的监视。
		
		
		//Redis Discard 命令用于取消事务，放弃执行事务块内的所有命令。
		
		
		
		
		//Redis Exec 命令用于执行所有事务块内的命令。
		/**
		 * Return:
		 * 事务块内所有命令的返回值，按命令执行的先后顺序排列。 当操作被打断时，返回空值 nil 。
		 */
		
	}
}
