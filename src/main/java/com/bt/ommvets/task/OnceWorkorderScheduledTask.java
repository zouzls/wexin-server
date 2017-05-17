//package com.bt.ommvets.task;
//
//import org.springframework.scheduling.annotation.SchedulingConfigurer;
//import org.springframework.scheduling.config.ScheduledTaskRegistrar;
//import org.springframework.scheduling.support.CronTrigger;
//import org.springframework.stereotype.Component;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
///**
// * @author zouzl
// * @create 2017-05-11-17:26
// */
//@Component
//public class OnceWorkorderScheduledTask implements SchedulingConfigurer {
//    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
//
//    private static final String DEFAULT_CRON = "0/10 * * * * ?";
//    private String cron = DEFAULT_CRON;
//
//
//    @Override
//    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
//        taskRegistrar.addTriggerTask(new Runnable() {
//            @Override
//            public void run() {
//
//                System.out.println("动态修改定时任务cron参数，当前时间：" + dateFormat.format(new Date()));
//            }
//        }, triggerContext -> {
//            // 定时任务触发，可修改定时任务的执行周期
//            CronTrigger trigger = new CronTrigger(cron);
//            Date nextExecDate = trigger.nextExecutionTime(triggerContext);
//            return nextExecDate;
//        });
//    }
//
//    public void setCron(String cron) {
//        this.cron = cron;
//    }
//}
