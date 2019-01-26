package com.swp.quartz;

import com.swp.quartz.scheduler.CronScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-01-23 5:01 PM
 */
@Component
public class ScheduleStartupRunner implements CommandLineRunner {

    @Autowired
    private CronScheduler cronScheduler;

    @Override
    public void run(String... args) throws Exception {
        cronScheduler.scheduleJobs();
    }
}
