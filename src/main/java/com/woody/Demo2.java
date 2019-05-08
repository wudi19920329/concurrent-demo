package com.woody;

/**
 *
 *
 * @author wudih
 * @date 2019/5/6 19:17
 * @since 1.0.0
 */
public class Demo2 {
    volatile int x = 11;
    volatile boolean v = false;

    public void writer() {
        x = 42;
        v = true;
    }

    public void reader() {
        if (v) {
            System.out.println(x);
            return;
        }
        System.out.println("------");
    }

    public static void main(String[] args) {
        Demo2 demo2 = new Demo2();
        new Thread(() -> demo2.writer()).start();
        new Thread(() -> demo2.reader()).start();

    }
}
