package store.yunqixinxi.com.timeTake;

import org.springframework.stereotype.Component;
import store.yunqixinxi.com.common.LoggerBase;

@Component
public class Task extends LoggerBase {
    private Integer cc = 1;

    //@Scheduled(cron = "0/5 * * * * *")
    public void test(){
        logger.info("第{}次执行定时任务",cc);
        cc++;
    }
}
