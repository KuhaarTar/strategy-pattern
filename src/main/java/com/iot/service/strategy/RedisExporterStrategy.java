package com.iot.service.strategy;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service("redis")
@RequiredArgsConstructor
public class RedisExporterStrategy implements ExporterStrategy {

    private final StringRedisTemplate redisTemplate;

    private static final String REDIS_LIST_KEY = "iot:dataset";

    @Override
    public void exportDataToSource(String data) {
        redisTemplate.opsForList().rightPush(REDIS_LIST_KEY, data);
    }
}
