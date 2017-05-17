package com.bt.ommvets.task;

import com.bt.ommvets.entity.WorkorderAutoRule;
import com.bt.ommvets.service.WorkorderAutoRuleService;
import com.bt.ommvets.service.WorkorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ScheduledFuture;

/**
 * @author zouzl
 * @create 2017-05-11-11:21
 */
@Component
public class QueryRuleScheduledTask {
    Calendar cal = Calendar.getInstance();

    @Autowired
    private WorkorderService workorderService;
    @Autowired
    private WorkorderAutoRuleService workorderAutoRuleService;

    @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    private HashMap<String,ScheduledFuture<?>> futureMap=new HashMap<>();

    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
        return new ThreadPoolTaskScheduler();
    }

    @Scheduled(fixedRate = 5000)
    public void createSheduleWorkorder() {
        List<WorkorderAutoRule> autoRules = workorderAutoRuleService.findAllNoUsedAutoRule();
        for (WorkorderAutoRule rule : autoRules) {
            if (rule.getAutoType()==WorkorderAutoRule.AUTOTYPE_ONCE&&futureMap.get(rule.getId())==null){//一次定时任务

                Date scheduledTime = rule.getScheduledTime();
                cal.setTime(scheduledTime);
                int year = cal.get(Calendar.YEAR);
                int month=cal.get(Calendar.MONTH)+1;
                int day=cal.get(Calendar.DAY_OF_MONTH);
                int hour=cal.get(Calendar.HOUR_OF_DAY);
                int minute= cal.get(Calendar.MINUTE);
                int second= cal.get(Calendar.SECOND);
                System.out.println(year+" "+month+" "+day+" "+hour+" "+minute+" "+second);
                String cron =second+" "+minute+" "+hour+" "+day+" "+month+" ?";//"0 33 21 13 5 ?";

                ScheduledFuture<?> future=threadPoolTaskScheduler.schedule(new MyRunnable(rule), new CronTrigger(cron));
                futureMap.put(rule.getId(),future);
            }
            if (rule.getAutoType()==WorkorderAutoRule.AUTOTYPE_CIRCLE&&futureMap.get(rule.getId())==null){//一次定时任务

                Date scheduledTime = rule.getScheduledTime();
                cal.setTime(scheduledTime);
                int year = cal.get(Calendar.YEAR);
                int month=cal.get(Calendar.MONTH)+1;
                int day=cal.get(Calendar.DAY_OF_MONTH);
                int hour=cal.get(Calendar.HOUR_OF_DAY);
                int minute= cal.get(Calendar.MINUTE);
                int second= cal.get(Calendar.SECOND);

                int circleType=rule.getCycleType();

                String cron =second+" "+minute+" "+hour+" "+day+"/"+circleType*7+" * ?";//"0 33 21 13 5 ?";

                ScheduledFuture<?> future=threadPoolTaskScheduler.schedule(new MyRunnable(rule), new CronTrigger(cron));
                futureMap.put(rule.getId(),future);
            }
        }
    }

    private class MyRunnable implements Runnable {
        private WorkorderAutoRule rule;
        public MyRunnable(WorkorderAutoRule rule){
            this.rule=rule;
        }
        @Override
        public void run() {
            workorderService.addWorkorderByAutoRule(rule);
        }
    }
}
