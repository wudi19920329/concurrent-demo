package com.woody.producerConsumer;

/**
 *
 *
 * @author wudih
 * @date 2019/5/7 9:56
 * @since 1.0.0
 */
public class Consumer implements Runnable {
    private Gun gun;

    public Consumer(Gun gun) {
        this.gun = gun;
    }



    @Override
    public void run() {
        while(true) {
            gun.shoot();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
