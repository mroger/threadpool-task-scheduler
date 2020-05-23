package br.org.roger.estudos.threadscheduler.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@Configuration
public class ThreadschedulerConfiguration {

    @Bean
    public ThreadPoolTaskScheduler myScheduler() {
        final ThreadPoolTaskScheduler tpts = new ThreadPoolTaskScheduler();
        tpts.setThreadNamePrefix("TNP-");
        tpts.setPoolSize(5);
        tpts.setAwaitTerminationSeconds(5);
        tpts.setWaitForTasksToCompleteOnShutdown(true);

        return tpts;
    }
}
