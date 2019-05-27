package jp.co.takawagu.rootBox.config

import io.lettuce.core.RedisURI
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisPassword
import org.springframework.data.redis.connection.RedisStandaloneConfiguration
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory

@Configuration
class RedisConfig {

    @Bean
    fun redisConnectionFactory(): LettuceConnectionFactory {
        val uri = RedisURI.create(System.getenv("REDIS_URL"))
        return LettuceConnectionFactory(
                RedisStandaloneConfiguration().apply {
                    hostName = uri.host
                    port = uri.port
                    password = RedisPassword.of(uri.password)
                })
    }
}