package 代码库.缓存.Redis;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.matchers.JUnitMatchers.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.hamcrest.core.IsNull;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.mysql.jdbc.TimeUtil;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

public class RedisDemo {
	private Jedis jedis;

	@Before
	public void setUp() {
		// 链接redis服务器
		jedis = new Jedis("127.0.0.1", 6379);
		// 权限认证
		// jedis.auth("12345");
	}

	// @Test
	// public void hihi(){
	// System.err.println(jedis.flushDB());
	// System.err.println(jedis.keys("*"));
	// }
	/**
	 * redis 存储字符串
	 */
	@Test
	public void testString() {
		// Redis SET 命令用于设置给定 key 的值。如果 key 已经存储其他值， SET 就覆写旧值，且无视类型。
		/**
		 * Return: 在 Redis 2.6.12 以前版本， SET 命令总是返回 OK 。 从 Redis 2.6.12 版本开始， SET
		 * 在设置操作成功完成时，才返回 OK 。
		 */
		jedis.set("key", "value");
		// Redis Get 命令用于获取指定 key 的值。如果 key 不存在，返回 nil 。如果key
		// 储存的值不是字符串类型，返回一个错误。
		/**
		 * Return: 返回 key 的值，如果 key 不存在时，返回 nil。 如果 key 不是字符串类型，那么返回一个错误。
		 */
		assertThat("value", equalTo(jedis.get("key")));
		assertThat(null, equalTo(jedis.get("keyNull")));
		// Redis Getrange 命令用于获取存储在指定 key 中字符串的子字符串。字符串的截取范围由 start 和 end
		// 两个偏移量决定(包括 start 和 end 在内)。
		/**
		 * 截取得到的子字符串。(key为空返回空字符串)
		 */
		assertThat(true, is(StringUtils.isEmpty(jedis.getrange("keyNull", 0, 1))));
		assertThat("va", equalTo(jedis.getrange("key", 0, 1)));
		assertThat("value", equalTo(jedis.getrange("key", 0, -1)));
		// Redis Append 命令用于为指定的 key 追加值。
		// 如果 key 已经存在并且是一个字符串， APPEND 命令将 value 追加到 key 原来的值的末尾。
		// 如果 key 不存在， APPEND 就简单地将给定 key 设为 value ，就像执行 SET key value 一样。
		/**
		 * return: 追加指定值之后， key 中字符串的长度。
		 */
		jedis.set("keyLen", "a");
		assertThat(2L, is(jedis.append("keyLen", "b")));
		// Redis Getset 命令用于设置指定 key 的值，并返回 key 旧的值。
		/**
		 * Return: 返回给定 key 的旧值。 当 key 没有旧值时 当 key 不存在时,set 添加 key:value,返回
		 * null。(redis客户端返回nil) 当 key 存在但不是字符串类型时，返回一个错误。
		 */
		jedis.set("key", "valueOld");
		assertThat("valueOld", equalTo(jedis.getSet("key", "valueNew")));
		assertThat(null, is(jedis.getSet("key1", "value")));
		assertThat("value", equalTo(jedis.getSet("key1", "valueNew")));

		jedis.del("key1");
		assertThat(null, is(jedis.get("key1")));
		// Getbit 命令用于对 key 所储存的字符串值，获取指定偏移量上的位(bit)。
		/**
		 * Return: 字符串值指定偏移量上的位(bit)。 当偏移量 OFFSET 比字符串值的长度大，或者 key 不存在时，返回 0 。
		 */

		// Redis Setex 命令为指定的 key 设置值及其过期时间。如果 key 已经存在， SETEX 命令将会替换旧的值。
		/**
		 * Return: 设置成功时返回 OK 。
		 */
		jedis.setex("keyTime", 5, "value");
		// Redis Setnx（SET if Not eXists） 命令在指定的 key 不存在时，为 key 设置指定的值。
		/**
		 * Return: 设置成功，返回 1 。 设置失败，返回 0 。
		 */
		// Redis Setrange 命令用指定的字符串覆盖给定 key 所储存的字符串值，覆盖的位置从偏移量 offset 开始。
		/**
		 * Return: 被修改后的字符串长度。
		 */
		// Redis Strlen 命令用于获取指定 key 所储存的字符串值的长度。当 key 储存的不是字符串值时，返回一个错误。
		/**
		 * Return: 字符串值的长度。 当 key 不存在时，返回 0。
		 */
		// 插入多个key:value
		jedis.mset("name", "cy", "age", String.valueOf(Long.MAX_VALUE - 1));
		// +1
		jedis.incr("age");
		assertThat(String.valueOf(Long.MAX_VALUE), is(jedis.get("age")));
	}

	/**
	 * redis 操作Map
	 */
	@Test
	public void testMap() {

		jedis.del("myhash");
		jedis.hset("myhash", "field1", "foo");
		// Redis Hexists 命令用于查看哈希表的指定字段是否存在。
		/**
		 * 如果哈希表含有给定字段，返回 1 。 如果哈希表不含有给定字段，或 key 不存在，返回 0 。
		 * 
		 * JAVA: true false
		 */
		assertThat(true, is(jedis.hexists("myhash", "field1")));
		assertThat(false, is(jedis.hexists("myhash", "field2")));
		// Redis Hget 命令用于返回哈希表中指定字段的值。
		/**
		 * 返回给定字段的值。如果给定的字段或 key 不存在时，返回 nil(JAVA null) 。
		 */
		assertThat("foo", is(jedis.hget("myhash", "field1")));
		assertThat(null, is(jedis.hget("myhash", "field2")));
		// Redis Hgetall 命令用于返回哈希表中，所有的字段和值。
		/**
		 * 以列表形式返回哈希表的字段及字段值。 若 key 不存在，返回空列表。
		 */
		System.err.println("Redis Hgetall --> " + jedis.hgetAll("myhash"));
		// Redis Hdel 命令用于删除哈希表 key 中的一个或多个指定字段，不存在的字段将被忽略。
		/**
		 * 被成功删除字段的数量，不包括被忽略的字段。
		 */
		jedis.hset("myhash", "field2", "foo");
		jedis.hset("myhash", "field3", "foo");
		assertThat(1L, is(jedis.hdel("myhash", "field1")));
		assertThat(2L, is(jedis.hdel("myhash", "field3", "field2", "field1")));

		Map<String, String> map = new HashMap<String, String>();
		map.put("cy", "chenyong");
		map.put("age", "25");
		// Redis Hmset 命令用于同时将多个 field-value (字段-值)对设置到哈希表中。
		// 此命令会覆盖哈希表中已存在的字段。
		// 如果哈希表不存在，会创建一个空哈希表，并执行 HMSET 操作。
		/**
		 * 如果命令执行成功，返回 OK 。
		 */
		assertThat("OK", is(jedis.hmset("user", map)));
		// Redis Hmget 命令用于返回哈希表中，一个或多个给定字段的值。
		// 如果指定的字段不存在于哈希表，那么返回一个 nil 值。
		/**
		 * 一个包含多个给定字段关联值的表，表值的排列顺序和指定字段的请求顺序一样。
		 */
		System.err.println("Redis Hmget --> " + jedis.hmget("user", "cy", "age"));
		// 删除Map中属性值
		jedis.hdel("user", "age");
		// 修改Map中属性值
		jedis.hset("user", "age", "28");
		//Redis Hlen 命令用于获取哈希表中字段的数量。
		/**
		 * 哈希表中字段的数量。 当 key 不存在时，返回 0 。
		 */
		assertThat(2L, is(jedis.hlen("user")));
		// 是否存在key为user的记录 返回true
		assertThat(true, is(jedis.exists("user")));
		//Redis Hkeys 命令用于获取哈希表中的所有字段名。
		/**
		 * 包含哈希表中所有字段的列表。 当 key 不存在时，返回一个空列表。
		 */
		System.err.println("Redis Hkeys --> "+jedis.hkeys("user"));// 返回map对象中的所有key
		//Redis Hvals 命令返回哈希表所有字段的值。
		/**
		 * 一个包含哈希表中所有值的表。 当 key 不存在时，返回一个空表。
		 */
		System.out.println(jedis.hvals("user"));// 返回map对象中的所有value
		
		
		//Redis Hincrby 命令用于为哈希表中的字段值加上指定增量值。
		//增量也可以为负数，相当于对指定字段进行减法操作。
		//如果哈希表的 key 不存在，一个新的哈希表被创建并执行 HINCRBY 命令。
		//如果指定的字段不存在，那么在执行命令前，字段的值被初始化为 0 。
		//对一个储存字符串值的字段执行 HINCRBY 命令将造成一个错误。
		//本操作的值被限制在 64 位(bit)有符号数字表示之内。
		/**
		 * 执行 HINCRBY 命令之后，哈希表中字段的值。
		 */
		jedis.hset("user", "age", "28");
		assertThat(30L, is(jedis.hincrBy("user", "age", 2L)));
		
		//Redis Hsetnx 命令用于为哈希表中不存在的的字段赋值 。
		//如果哈希表不存在，一个新的哈希表被创建并进行 HSET 操作。
		//如果字段已经存在于哈希表中，操作无效。
		//如果 key 不存在，一个新哈希表被创建并执行 HSETNX 命令。
		assertThat(0L, is(jedis.hsetnx("user", "age", "11")));
		
		//Redis Hincrbyfloat 命令用于为哈希表中的字段值加上指定浮点数增量值。
		//如果指定的字段不存在，那么在执行命令前，字段的值被初始化为 0 。
		/**
		 * 执行 Hincrbyfloat 命令之后，哈希表中字段的值。
		 */
	}

	/**
	 * jedis操作List
	 */
	@Test
	public void testList() {
		// 开始前，先移除所有的内容
		jedis.del("java framework");
		System.out.println(jedis.lrange("java framework", 0, -1));
		// 先向key java framework中存放三条数据
		jedis.lpush("java framework", "spring");
		jedis.lpush("java framework", "struts");
		jedis.lpush("java framework", "hibernate");
		// 再取出所有数据jedis.lrange是按范围取出，
		// 第一个是key，第二个是起始位置，第三个是结束位置，jedis.llen获取长度 -1表示取得所有
		System.out.println(jedis.lrange("java framework", 0, -1));

		jedis.del("java framework");
		jedis.rpush("java framework", "spring");
		jedis.rpush("java framework", "struts");
		jedis.rpush("java framework", "hibernate");
		System.out.println(jedis.lrange("java framework", 0, -1));
	}

	/**
	 * jedis操作Set
	 */
	@Test
	public void testSet() {
		// 添加
		jedis.sadd("user", "liuling");
		jedis.sadd("user", "xinxin");
		jedis.sadd("user", "ling");
		jedis.sadd("user", "zhangxinxin");
		jedis.sadd("user", "who");
		// 移除noname
		jedis.srem("user", "who");
		System.out.println(jedis.smembers("user"));// 获取所有加入的value
		System.out.println(jedis.sismember("user", "who"));// 判断 who
															// 是否是user集合的元素
		System.out.println(jedis.srandmember("user"));
		System.out.println(jedis.scard("user"));// 返回集合的元素个数
	}

	@Test
	public void testLink() throws InterruptedException {
		// jedis 排序
		// 注意，此处的rpush和lpush是List的操作。是一个双向链表（但从表现来看的）
		jedis.del("a");// 先清除数据，再加入数据进行测试
		jedis.rpush("a", "1");
		jedis.lpush("a", "6");
		jedis.lpush("a", "3");
		jedis.lpush("a", "9");
		System.out.println(jedis.lrange("a", 0, -1));// [9, 3, 6, 1]
		System.out.println(jedis.sort("a")); // [1, 3, 6, 9] //输入排序后结果
		System.out.println(jedis.lrange("a", 0, -1));
	}

	/**
	 * 指令
	 */
	@Test
	public void testCommand() throws Exception {
		jedis.set("diamondDog", "diamondDog");
		jedis.expire("diamondDog", 1);// 1s 设置过期时间
		assertThat("diamondDog", equalTo(jedis.get("diamondDog")));
		// key值不存在返回-2，未设置过期时间返回-1
		System.err.println("diamondDog剩余过期时间：" + jedis.ttl("diamondDog"));
		// 返回 1,0
		jedis.rename("diamondDog", "DiamondDog");// 修改key的名称，key冲突则覆盖
		jedis.renamenx("DiamondDog", "diamondDog");// 仅当 newkey 不存在时，将 key 改名为
													// newkey 。
		assertThat("string", equalTo(jedis.type("diamondDog")));
		jedis.persist("DiamongDog");// 移除 key 的过期时间，key 将持久保持。
		TimeUnit.SECONDS.sleep(1);
		assertThat(null, is(jedis.get("diamondDog")));
		jedis.expireAt("--", 1000 * 1);
		jedis.set("1_a", "a");
		jedis.set("1_b", "b");
		jedis.set("1_c", "c");
		System.err.println(jedis.keys("1_*"));

		jedis.select(0);// redis默认选择数据库为0
		jedis.move("1_a", 1);// 移动key到数据库1，如果key冲突则移动失败返回0
		jedis.move("1_b", 1);
		jedis.select(1);// 选择数据库1
		System.err.println(jedis.randomKey());// 从当前数据库中随机返回一个 key 。

	}

	@Test
	public void testRedisPool() {
		RedisUtil.getJedis().set("newname", "中文测试");
		System.out.println(RedisUtil.getJedis().get("newname"));
	}
}
