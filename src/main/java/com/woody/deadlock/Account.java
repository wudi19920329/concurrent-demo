package com.woody.deadlock;

import java.math.BigDecimal;

/**
 *
 *
 * @author wudih
 * @date 2019/5/8 15:28
 * @since 1.0.0
 */
public class Account {
    private BigDecimal balance;

    public void transfer(Account targetAccount, BigDecimal offset){
        synchronized (this) {
            this.balance.subtract(offset);
            synchronized (targetAccount) {
                targetAccount.balance.add(offset);
            }
        }
    }

    public Account(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
