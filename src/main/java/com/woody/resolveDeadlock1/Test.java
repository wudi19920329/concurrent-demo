package com.woody.resolveDeadlock1;

import java.math.BigDecimal;

/**
 *
 *
 * @author wudih
 * @date 2019/5/8 16:25
 * @since 1.0.0
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        Account a = new Account();
        Account b = new Account();
        Thread t1 = new Thread(() -> {
            a.transfer(b, BigDecimal.valueOf(100));
        });
        Thread t2 = new Thread(() -> {
            b.transfer(a, BigDecimal.valueOf(50));
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("a的余额" + a.getBalance());
        System.out.println("b的余额" + b.getBalance());
        System.out.println("执行结束");
    }
}
