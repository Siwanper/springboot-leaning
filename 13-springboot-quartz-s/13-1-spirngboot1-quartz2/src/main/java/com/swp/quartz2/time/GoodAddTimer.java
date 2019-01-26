package com.swp.quartz2.time;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-01-24 11:57 AM
 */
public class GoodAddTimer extends QuartzJobBean {

    private static final Logger logger = LoggerFactory.getLogger(GoodAddTimer.class);

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("分布式节点quartz-cluster-node-first , 商品添加完成后执行任务，任务时间：{}",new Date());
    }
}
