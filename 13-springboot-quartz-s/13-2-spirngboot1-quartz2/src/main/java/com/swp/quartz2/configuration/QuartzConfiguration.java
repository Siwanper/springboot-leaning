package com.swp.quartz2.configuration;

import org.quartz.spi.JobFactory;
import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

import javax.sql.DataSource;

/**
 * 描述:
 * quartz配置文件
 *
 * @outhor ios
 * @create 2019-01-24 10:24 AM
 */
@Configuration
@EnableScheduling
public class QuartzConfiguration {

    /**
     * 实现任务实例化方式
     */
    public static class AutowiringSpringBootJobFactory extends SpringBeanJobFactory implements ApplicationContextAware {

        private transient AutowireCapableBeanFactory beanFactory;

        @Override
        public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
            beanFactory = applicationContext.getAutowireCapableBeanFactory();
        }

        /**
         * 将job实例交给spring ioc托管
         * 我们在job实例实现类内直接可以使用spring注入调用被spring ioc管理的实例。
         *
         * @param bundle
         * @return
         * @throws Exception
         */
        @Override
        protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
            Object jobInstance = super.createJobInstance(bundle);
            /**
             * 将任务实例交由spring ioc管理
             */
            beanFactory.autowireBean(jobInstance);
            return jobInstance;
        }
    }

    /**
     * 配置任务工厂实例
     * @param context
     * @return
     */
    @Bean
    public JobFactory jobFactory(ApplicationContext context) {
        /**
         * 采用自定义任务工厂，整合spring实例来完成构建任务
         */
        AutowiringSpringBootJobFactory jobFactory = new AutowiringSpringBootJobFactory();
        jobFactory.setApplicationContext(context);
        return jobFactory;
    }

    /**
     * 配置任务调度器
     * 使用项目数据源作为quartz数据源
     *
     * @param jobFactory
     * @param dataSource
     * @return
     */
    @Bean(destroyMethod = "destroy", autowire = Autowire.NO)
    public SchedulerFactoryBean schedulerFactoryBean(JobFactory jobFactory, DataSource dataSource) {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        // 将spring管理job自定义工厂交由调度器维护
        schedulerFactoryBean.setJobFactory(jobFactory);
        // 设置覆盖已存在的任务
        schedulerFactoryBean.setOverwriteExistingJobs(true);
        // 项目启动完成后，等待2秒后开始执行调度器初始化
        schedulerFactoryBean.setStartupDelay(2);
        // 设置调度器自动运行
        schedulerFactoryBean.setAutoStartup(true);
        // 设置数据源，使用与项目统一管理数据源
        schedulerFactoryBean.setDataSource(dataSource);
        // 设置上下文spring bean name
        schedulerFactoryBean.setApplicationContextSchedulerContextKey("applicationContext");
        // 设置配置文件的位置
        schedulerFactoryBean.setConfigLocation(new ClassPathResource("/quartz.properties"));
        return schedulerFactoryBean;
    }


}
