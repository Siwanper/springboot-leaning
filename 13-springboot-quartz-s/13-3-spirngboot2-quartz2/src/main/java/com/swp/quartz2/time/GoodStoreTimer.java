package com.swp.quartz2.time;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * 描述: 商品定时检测库存任务
 *
 * @outhor ios
 * @create 2019-01-24 11:57 AM
 */
public class GoodStoreTimer extends QuartzJobBean {

    private static final Logger logger = LoggerFactory.getLogger(GoodStoreTimer.class);

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("分布式节点quartz-cluster-node-second, 执行库存检查定时任务，执行时间：{}",new Date());
    }
}
