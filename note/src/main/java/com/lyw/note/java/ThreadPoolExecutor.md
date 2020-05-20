#ThreadPoolExecutor
##构造函数
```java
    public ThreadPoolExecutor(int corePoolSize,
                              int maximumPoolSize,
                              long keepAliveTime,
                              TimeUnit unit,
                              BlockingQueue<Runnable> workQueue,
                              ThreadFactory threadFactory,
                              RejectedExecutionHandler handler) {
        if (corePoolSize < 0 ||
            maximumPoolSize <= 0 ||
            maximumPoolSize < corePoolSize ||
            keepAliveTime < 0)
            throw new IllegalArgumentException();
        if (workQueue == null || threadFactory == null || handler == null)
            throw new NullPointerException();
        this.corePoolSize = corePoolSize;
        this.maximumPoolSize = maximumPoolSize;
        this.workQueue = workQueue;
        this.keepAliveTime = unit.toNanos(keepAliveTime);
        this.threadFactory = threadFactory;
        this.handler = handler;
    }
```
###example
```java
    ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 20, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>(100000), new NamedThreadFactory("LYW-PUBLISHER"));
```
###参数说明                            
>- corePoolSize：线程池核心线程数（平时保留的线程数）
>- maximumPoolSize：线程池最大线程数（当workQueue都放不下时，启动新线程，最大线程数）
>- keepAliveTime：超出corePoolSize数量的线程的保留时间。
>- unit：keepAliveTime单位
>- workQueue：阻塞队列，存放来不及执行的线程
>- ArrayBlockingQueue：构造函数一定要传大小
>- LinkedBlockingQueue：构造函数不传大小会默认为（Integer.MAX_VALUE ），当大量请求任务时，容易造成 内存耗尽。
>- SynchronousQueue：同步队列，一个没有存储空间的阻塞队列 ，将任务同步交付给工作线程。
>- PriorityBlockingQueue : 优先队列
>- threadFactory：线程工厂
>- handler：饱和策略  
AbortPolicy（默认）：直接抛弃  
CallerRunsPolicy：用调用者的线程执行任务  
DiscardOldestPolicy：抛弃队列中最久的任务  
DiscardPolicy：抛弃当前任务  
###应用说明
Java 线程池以有界队列的线程池为例，当新任务提交时，如果运行的线程少于 corePoolSize，则创建新线程来处理请求。如果正在运行的线程数等于 corePoolSize 时，则新任务被添加到队列中，直到队列满。当队列满了后，会继续开辟新线程来处理任务，但不超过 maximumPoolSize。当任务队列满了并且已开辟了最大线程数，此时又来了新任务，ThreadPoolExecutor 会拒绝服务。
##阿里开发手册
>**线程池不使用 Executors 去创建，而是通过 ThreadPoolExecutor 的方式，这样 的处理方式让写的同学更加明确线程池的运行规则，规避资源耗尽的风险。**  

说明： Executors 返回的线程池对象的弊端如下：

1. FixedThreadPool 和 SingleThreadPool : 允许的请求队列长度为 Integer.MAX_VALUE ，可能会堆积大量的请求，从而导致 OOM 。
2. CachedThreadPool 和 ScheduledThreadPool : 允许的创建线程数量为 Integer.MAX_VALUE ，可能会创建大量的线程，从而导致 OOM 。
