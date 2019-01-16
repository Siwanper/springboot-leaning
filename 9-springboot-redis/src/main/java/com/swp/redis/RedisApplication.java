package com.swp.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
//maxInactiveIntervalInSeconds: 设置Session失效时间，使用Redis Session之后，原Boot的server.session.timeout属性不再生效
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 86400*30)
public class RedisApplication extends SpringBootServletInitializer {

	// 使用外置tomcat，继承SpringBootServletInitializer，重写configure
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(RedisApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(RedisApplication.class, args);
	}

}

