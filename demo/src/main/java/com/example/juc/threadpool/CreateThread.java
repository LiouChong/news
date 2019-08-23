package com.example.juc.threadpool;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class CreateThread {
    public static AtomicInteger cout = new AtomicInteger(1);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        getExecutorCallable();
    }

    /**
     * 通过callable方法创建线程
     * @throws ExecutionException
     * @throws InterruptedException
     */
    private static void callableCreate() throws ExecutionException, InterruptedException {
        ThreadCall threadCall = new ThreadCall();
        FutureTask<Integer> thread1 = new FutureTask<>(threadCall);

        Thread thread = new Thread(thread1);
        thread.start();
        System.out.println("主线程");
        System.out.println("子线程是否执行完" + thread1.isDone());
        System.out.println("返回结果" + thread1.get());
        System.out.println("主线程完毕");
    }

    /**
     * 通过线程池来创建Runable线程（Thread线程略）
     */
    private static void getExecutorsThread() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 5; i++) {
            executorService.execute(() -> System.out.println("Thread-" + cout.getAndAdd(1) + " 被创建"));
        }
        executorService.shutdown();
    }

    private static void getExecutorCallable() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        getExecutorCallThreadMethod2(executorService);
        executorService.shutdown();

    }

    private static void getExecutorCallThreadMethod1(ExecutorService executorService) throws ExecutionException, InterruptedException {
        for (int i = 0; i < 5; i++) {
            ThreadCall threadCall = new ThreadCall();
            Future<Integer> futureTask = executorService.submit(threadCall);
            System.out.println("计算的值:" + futureTask.get());
            System.out.println(i + 1 + "次循环结束");
        }
    }

    private static void getExecutorCallThreadMethod2(ExecutorService executorService) throws ExecutionException, InterruptedException {
        for (int i = 0; i < 10; i++) {
            ThreadCall threadCall = new ThreadCall();
            FutureTask<Integer> futureTask = new FutureTask<>(threadCall);
            executorService.submit(futureTask);
        }
    }
}

class ThreadCall implements Callable<Integer> {
    private Integer result = 0;


    @Override
    public Integer call() throws Exception {
        for (int j = 0; j < 10; j++) {
            result = result + j;
        }

        System.out.println(Thread.currentThread().getName() + "计算的值:" + result);
        return result;
    }
}
