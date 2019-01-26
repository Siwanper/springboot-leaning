package com.swp.quartz.scheduler;

import com.swp.quartz.job.ScheduledJob1;
import com.swp.quartz.job.ScheduledJob2;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-01-23 4:50 PM
 */
@Component
public class CronScheduler {

    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;


    public void scheduleJobs() throws SchedulerException {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        scheduleJob1(scheduler);
        scheduleJob2(scheduler);
    }

    private void scheduleJob1(Scheduler scheduler) throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(ScheduledJob1.class).withIdentity("job1", "group1").build();
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("*/6 * * * * ?");
        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1").withSchedule(scheduleBuilder).build();
        scheduler.scheduleJob(jobDetail, trigger);
    }

    private void scheduleJob2(Scheduler scheduler) throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(ScheduledJob2.class).withIdentity("job2", "group2").build();
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("*/12 * * * * ?");
        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger2", "group2").withSchedule(scheduleBuilder).build();
        scheduler.scheduleJob(jobDetail, trigger);
    }


}
