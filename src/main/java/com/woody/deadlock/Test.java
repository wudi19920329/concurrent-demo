package com.woody.deadlock;

import java.math.BigDecimal;

/**
 *
 *
 * @author wudih
 * @date 2019/5/8 15:27
 * @since 1.0.0
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        Account a = new Account(BigDecimal.valueOf(200));
        Account b = new Account(BigDecimal.valueOf(200));
        Thread t1 = new Thread(() -> {
            a.transfer(b, BigDecimal.valueOf(100));
        });
        Thread t2 = new Thread(() -> {
            b.transfer(a, BigDecimal.valueOf(100));
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("执行结束");
    }

}
