package com.woody;

public class Demo1 {
    private long count = 0;

     void add10K() {
        int temp = 0;
        while (temp++ < 10000) {
            count++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final Demo1 demo = new Demo1();
        Thread t1 = new Thread(() -> demo.add10K());
        Thread t2 = new Thread(() -> demo.add10K());
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println(demo.count);

    }
}
