package com.woody.resolveDeadlock1;

import java.math.BigDecimal;

/**
 *
 *
 * @author wudih
 * @date 2019/5/8 16:24
 * @since 1.0.0
 */
public class Account {
    private BigDecimal balance = BigDecimal.valueOf(200);
    private static final Allocator ALLOCATOR = new Allocator();

    public void transfer(Account target, BigDecimal offset) {
        // spin
        while (!ALLOCATOR.apply(this, target)) {
            System.out.println(Thread.currentThread().getName() + "等待中");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        synchronized (this) {
            this.balance = this.balance.subtract(offset);
            System.out.println(Thread.currentThread().getName() + "扣减" + offset + "元，剩余" + this.balance);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (target) {
                target.balance = target.balance.add(offset);
                System.out.println(Thread.currentThread().getName() + "增加" + offset + "元，剩余" + target.balance);
            }
        }
        ALLOCATOR.free(this, target);
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
