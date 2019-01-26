package com.swp.quartz2.good.service.impl;

import com.swp.quartz2.good.model.GoodInfoEntity;
import com.swp.quartz2.good.repository.GoodInfoRepository;
import com.swp.quartz2.good.service.GoodInfoService;
import com.swp.quartz2.time.GoodAddTimer;
import com.swp.quartz2.time.GoodSeckillTimer;
import com.swp.quartz2.time.GoodStoreTimer;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-01-24 11:34 AM
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class GoodInfoServiceImpl implements GoodInfoService {

    @Autowired
    private GoodInfoRepository repository;

    @Autowired
    private Scheduler scheduler;

    @Override
    public Long saveGood(GoodInfoEntity goodInfoEntity) throws SchedulerException {
        repository.save(goodInfoEntity);
        buildCreateGoodTimer();
        buildStoreGoodTimer();
        return goodInfoEntity.getId();
    }

    @Override
    public Long seckillGood(Long goodId) throws SchedulerException {
        buildSeckillTimer(goodId);
        return goodId;
    }

    private void buildCreateGoodTimer() throws SchedulerException {
        // 设置任务执行时间为 1 分钟后
        long startAtTime = System.currentTimeMillis() + 1000 * 60;
        // 任务名称，在同一group里面不能重复
        String name = UUID.randomUUID().toString();
        // 任务所属分组
        String group = GoodAddTimer.class.getName();
        // 创建任务
        JobDetail jobDetail = JobBuilder.newJob(GoodAddTimer.class).withIdentity(name, group).build();
        // 创建任务触发器
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity(name, group).startAt(new Date(startAtTime)).build();
        // 将任务与任务触发器绑定到调度器内
        scheduler.scheduleJob(jobDetail, trigger);
    }

    private void buildStoreGoodTimer() throws SchedulerException {

        // 任务名称，在同一group里面不能重复
        String name = UUID.randomUUID().toString();
        // 任务所属分组
        String group = GoodStoreTimer.class.getName();

        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/30 * * * * ?");
        // 创建任务
        JobDetail jobDetail = JobBuilder.newJob(GoodStoreTimer.class).withIdentity(name, group).build();

        Trigger trigger = TriggerBuilder.newTrigger().withIdentity(name, group).withSchedule(scheduleBuilder).build();
        scheduler.scheduleJob(jobDetail, trigger);

    }

    private void buildSeckillTimer(Long goodId) throws SchedulerException {
        // 设置任务执行时间为 5 分钟后
        long startAtTime = System.currentTimeMillis() + 1000 * 60 * 5;
        // 任务名称，在同一group里面不能重复
        String name = UUID.randomUUID().toString();
        // 任务所属分组
        String group = GoodSeckillTimer.class.getName();
        // 创建任务
        JobDetail jobDetail = JobBuilder.newJob(GoodSeckillTimer.class).withIdentity(name, group).build();
        jobDetail.getJobDataMap().put("goodId", goodId);
        // 创建任务触发器
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity(name, group).startAt(new Date(startAtTime)).build();
        // 将任务与任务触发器绑定到调度器内
        scheduler.scheduleJob(jobDetail, trigger);
    }



}
