package com.swp.quartz2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Quartz2Application {

	private static final Logger logger = LoggerFactory.getLogger(Quartz2Application.class);

	public static void main(String[] args) {
		logger.info("【【【【【【定时任务分布式节点 - quartz-cluster-node-one 已启动】】】】】】");
		SpringApplication.run(Quartz2Application.class, args);
	}

}

