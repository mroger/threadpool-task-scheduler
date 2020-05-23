package br.org.roger.estudos.threadscheduler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.Random;
import java.util.stream.IntStream;

@Component
public class MyTrigger {

    @Autowired
    @Qualifier("myScheduler")
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    @PostConstruct
    private void init() {
        IntStream.rangeClosed(1, 20)
            .forEachOrdered(id -> {
                System.out.println("Submitting task " + id);

                threadPoolTaskScheduler.scheduleWithFixedDelay(
                    new RunnableTask("Task - " + id),
                    10000);
/*                threadPoolTaskScheduler.scheduleAtFixedRate(
                    new RunnableTask("Task - " + id),
                    5000);*/
            });
    }
}

class RunnableTask implements Runnable{
    private String message;
    private Random rand;

    public RunnableTask(String message){
        this.message = message;
        this.rand = new Random();
    }

    @Override
    public void run() {
        long ts = (long) rand.nextInt(5000);
        System.out.println(new Date() + " - Runnable Task with " + message
            + " on thread " + Thread.currentThread().getName() + " - Sleeping for " + ts + " milliseconds");
        try {
            Thread.sleep(ts);
            System.out.println(new Date() + " - Awake "+ " on thread " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
