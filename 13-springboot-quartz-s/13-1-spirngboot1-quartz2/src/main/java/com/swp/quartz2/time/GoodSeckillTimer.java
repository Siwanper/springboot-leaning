package com.swp.quartz2.time;

import org.quartz.JobDataMap;
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
public class GoodSeckillTimer extends QuartzJobBean {

    private static final Logger logger = LoggerFactory.getLogger(GoodSeckillTimer.class);

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        long goodId = jobDataMap.getLong("goodId");
        logger.info("分布式节点quartz-cluster-node-first , 执行商品秒杀定时任务，执行商品 {},关注用户推送消息", goodId);
    }
    
}
