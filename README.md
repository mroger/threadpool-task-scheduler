# threadpool-task-scheduler
An example of Spring ThreadPoolTaskScheduler to make experiments with its API

## To start application

```gradle
# gradlew clean bootRun
```

## To see the number of threads in command line

Execute the command to find the PID for the ThreadschedulerApplication
```
# jps

16672 Launcher
12404 Jps
13972 RemoteMavenServer36
11656
13852 GradleDaemon
16684 ThreadschedulerApplication
5004 GradleDaemon
```

The PID we're looking for is 16684. Now we list the active threads, filtering by our thread prefix: "TNP-"
```
# jstack -l 16684 | grep TNP-

"TNP-5" #21 prio=5 os_prio=0 tid=0x0000000020278000 nid=0x19bc waiting on condition [0x0000000024c9f000]
"TNP-4" #20 prio=5 os_prio=0 tid=0x0000000021ff8800 nid=0x44f4 waiting on condition [0x000000002492f000]
"TNP-3" #19 prio=5 os_prio=0 tid=0x0000000022cd6800 nid=0x3850 waiting on condition [0x000000002482f000]
"TNP-2" #18 prio=5 os_prio=0 tid=0x0000000022cd6000 nid=0x23d0 waiting on condition [0x000000002472e000]
"TNP-1" #17 prio=5 os_prio=0 tid=0x0000000023004000 nid=0x2e90 waiting on condition [0x000000002462e000]
```

We can see that there are always 5 active threads that are the # of threads that we defined in the pool.

## To see the number of threads in jconsole

```
# jconsole
```

![]()

![]()
