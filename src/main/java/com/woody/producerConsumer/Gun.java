package com.woody.producerConsumer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * @author wudih
 * @date 2019/5/7 9:56
 * @since 1.0.0
 */
public class Gun {
    private List<Object> bullets = new ArrayList<>(20);
    public void shoot() {
        synchronized (this) {
            while (bullets.size() == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("消费者发射子弹...");
            bullets.remove(0);
            System.out.println("剩余子弹数：" + bullets.size());
            notify();
        }

    }

    public void push() {
        synchronized (this) {
            while (bullets.size() == 20) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("生产者压入子弹...");
            bullets.add(new Object());
            System.out.println("剩余子弹数" + bullets.size());
            notify();
        }

    }

    public List<Object> getBullets() {
        return bullets;
    }

    public void setBullets(List<Object> bullets) {
        this.bullets = bullets;
    }
}
