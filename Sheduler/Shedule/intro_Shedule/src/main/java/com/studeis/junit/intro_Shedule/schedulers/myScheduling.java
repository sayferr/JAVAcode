package com.studeis.junit.intro_Shedule.schedulers;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@EnableScheduling
@Component
public class myScheduling {

    //@Scheduled(fixedRate = 5 * 1000,  initialDelay = 5 * 1000)
    // */1 - every second
//    @Scheduled(cron = "* * * * * *")
//    public void executeTask() {
//        System.out.println("Time: " + LocalDateTime.now());
//    }
    //    @Scheduled(cron = "* * * * * *")


    //                TASK               //

    @Scheduled(cron = "*/1 * * * * *")
    public void task1() {
        System.out.println("every second");
    }

    @Scheduled(cron = "0 */1 * * * *")
    public void task2() {
        System.out.println("every minute");
    }

    @Scheduled(cron = "0 0 * * * *")
    public void task3() {
        System.out.println("every hour");
    }

//    @Scheduled(cron = "* * 0 * * *")
@Scheduled(cron = "0 0 0 * * *")
    public void task4() {
        System.out.println("every day");
    }

    @Scheduled(cron = "0 0 0 1 * *")
    public void task5() {
        System.out.println("Hi");
    }

    @Scheduled(cron = "* 30 10 * * *")
    public void task6() {
        System.out.println("every day 10:30");
    }

    @Scheduled(cron = "30 45 15 * * *")
    public void task7() {
        System.out.println("every day 15:45:30");
    }

    @Scheduled(cron = "0 0 9 * * 7")
    public void task8() {
        System.out.println("every sunday 9:00:00");
    }

    @Scheduled(cron = "* 15 8 * * 1")
    public void task9() {
        System.out.println("every monday 8:15");
    }

    @Scheduled(cron = "0 0 12 15 1 *")
    public void task10() {
        System.out.println("every january 12:00:00");
    }

    @Scheduled(cron = "*/30 * * * * *")
    public void task11() {
        System.out.println("every 30 seconds");
    }

    @Scheduled(cron = "* */15 * * * *")
    public void task12() {
        System.out.println("every 15 minutes");
    }

    @Scheduled(cron = "* * */2 * * *")
    public void task13() {
        System.out.println("every 2 hours");
    }

    @Scheduled(cron = "* * 0 */5 * *")
    public void task14() {
        System.out.println("every 5 days");
    }

    @Scheduled(cron = "* * * 1 */3 *")
    public void task15() {
        System.out.println("every 3 months");
    }

    @Scheduled(cron = "0,20,40,59 * * * * *")
    public void task16() {
        System.out.println("wow");
    }

    @Scheduled(cron = "* 0,20,40,59 * * * *")
    public void task17() {
        System.out.println("wOw");
    }

    @Scheduled(cron = "0 0 9,12,15 * * *")
    public void task18() {
        System.out.println("go");
    }

    @Scheduled(cron = "* * * * * 1,3,5")
    public void task19() {
        System.out.println("go to work");
    }

    @Scheduled(cron = "* * * * 6-8 5")
    public void task20() {
        System.out.println("relax");
    }

    @Scheduled(cron = "0 * 9,12,15 * * *")
    public void task21() {
        System.out.println("work");
    }

    @Scheduled(cron = "0 0 * * * 1-5")
    public void task22() {
        System.out.println("work :(");
    }

    @Scheduled(cron = "0 30 12 15 * *")
    public void task23() {
        System.out.println("cool");
    }

    @Scheduled(cron = "* * * * 1-6 7")
    public void task24() {
        System.out.println("uncool");
    }

    @Scheduled(cron = "*/5 30-45 * * * *")
    public void task25() {
        System.out.println("I want");
    }

    @Scheduled(cron = "59 59 23 L * *")
    public void task26() {
        System.out.println("friends");
    }

    @Scheduled(cron = "0 0 17 * * 5L")
    public void task27() {
        System.out.println("Last friday every month");
    }

    @Scheduled(cron = "0 0 18 ? * 5L")
    public void task28() {
        System.out.println("last day");
    }

    @Scheduled(cron = "* * * * * 3#2")
    public void task29() {
        System.out.println("every Wednesday 2 of every month");
    }

    @Scheduled(cron = "* * * * 1,7 1#3")
    public void task30() {
        System.out.println("I am done");
    }

    @Scheduled(cron = "0 */30 9-18 * * 1-5")
    public void task31() {
        System.out.println("I");
    }

    @Scheduled(cron = "*/10 0-5 * * * *")
    public void task32() {
        System.out.println("I am done");
    }

    @Scheduled(cron = "0 0 0 1 1,4,7,10 *")
    public void task33() {
        System.out.println("I am done");
    }

    @Scheduled(cron = "0 0 3 * 3 7L")
    public void task34() {
        System.out.println("I am done");
    }

    @Scheduled(cron = "0 0 9-11,14-18/2 * * 1-5")
    public void task35() {
        System.out.println("I am done");
    }

    @Scheduled(cron = "0 30 2 * * *")
    public void task36() {
        System.out.println("I am done");
    }

    @Scheduled(cron = "0 0 3 * * 7")
    public void task37() {
        System.out.println("I am done");
    }

    @Scheduled(cron = "0 0 9 1 * 1")
    public void task38() {
        System.out.println("I am done");
    }

    @Scheduled(cron = "0 */5 9-18 * * 1-5")
    public void task39() {
        System.out.println("I am done");
    }

    @Scheduled(cron = "0 30 16 * * 5")
    public void task40() {
        System.out.println("I am done");
    }
}
