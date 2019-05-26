package jp.co.takawagu.rootBox

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory
import redis.clients.jedis.JedisPoolConfig


@Configuration
class RedisConfig {

    @Bean
    fun jedisConnectionFactory(): RedisConnectionFactory {
        val poolConfig = JedisPoolConfig()
        poolConfig.maxIdle = 5
        poolConfig.minIdle = 1
        poolConfig.testOnBorrow = true
        poolConfig.testOnReturn = true
        poolConfig.testWhileIdle = true
        return JedisConnectionFactory(poolConfig)
    }

}