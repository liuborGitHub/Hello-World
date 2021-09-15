package utils;


import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.core.script.DefaultRedisScript;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author liubor
 * @date 2021/9/15 5:47 下午
 */
public class RedisLock {
	private static final Logger logger = LoggerFactory.getLogger(RedisLock.class);
	public static final Long LOCK_TIME_SECOND_3S = 3L;
	public static final int LOCK_RETRY_TIMES_5 = 5;
	public static final int LOCK_RETRY_TIMES_10 = 10;
	public static final Long LOCK_TIME_SECOND_5S = 5L;
	private static final Integer RELEASE_SUCCESS = 1;
	private static final String LOCK_KEY_PREFIX = "Lock:";
//	private static RedisClientUtil redisClientUtil = (RedisClientUtil)SpringContextHolder.getBean(RedisClientUtil.class);
	private static RedisTemplate redisTemplate;

	private RedisLock() {
	}

	public static boolean lock(String key, String reqId) {
		return lock(key, reqId, LOCK_TIME_SECOND_5S);
	}

	public static boolean lockRetry(String key, String reqId, int retryTimes) throws InterruptedException {
		for(int i = 0; i < retryTimes; ++i) {
			if (lock(key, reqId, LOCK_TIME_SECOND_5S)) {
				return true;
			}

			Thread.sleep(50L);
		}

		return lock(key, reqId, LOCK_TIME_SECOND_5S);
	}

	public static boolean lock(String key, String reqId, Long second) {
		final String lockKey = "Lock:" + key;
		logger.info("开始加锁，lockKey：{},reqId:{}", lockKey, reqId);
		List<Boolean> result = (List)redisTemplate.execute(new SessionCallback() {
			@Override
			public List<Boolean> execute(RedisOperations operations) throws DataAccessException {
				operations.multi();
				operations.opsForValue().setIfAbsent(lockKey, reqId);
				operations.expire(lockKey, second, TimeUnit.SECONDS);
				return operations.exec();
			}
		});
		logger.info("加锁结果，key：{},reqId:{}，结果：{}", new Object[]{lockKey, reqId, result});
		return CollectionUtils.isNotEmpty(result) && (Boolean)result.get(0);
	}

	public static boolean unLock(String key, String reqId) {
		String lockKey = "Lock:" + key;
		logger.info("开始解锁，lockKey：{},reqId:{}", lockKey, reqId);
		String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
		DefaultRedisScript<List> unLockScript = new DefaultRedisScript();
		unLockScript.setResultType(List.class);
		unLockScript.setScriptText(script);
		List<String> keyList = new ArrayList();
		keyList.add(lockKey);
		List result = (List)redisTemplate.execute(unLockScript, keyList, new Object[]{reqId});
		logger.info("解锁结果，key：{},reqId:{}，结果：{}", new Object[]{lockKey, reqId, result});
		return CollectionUtils.isNotEmpty(result) && RELEASE_SUCCESS.equals(result.get(0));
	}

	static {
//		redisTemplate = redisClientUtil.getRedisTemplate();
	}
}
