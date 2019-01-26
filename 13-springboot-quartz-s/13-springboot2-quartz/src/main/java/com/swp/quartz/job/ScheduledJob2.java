package com.swp.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-01-23 4:47 PM
 */
public class ScheduledJob2 implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("Scheduled Job 2 ...");
    }
}
