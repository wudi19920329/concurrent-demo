package com.woody.producerConsumer;

public class Producer implements Runnable {
    private Gun gun;

    public Producer(Gun gun) {
        this.gun = gun;
    }



    @Override
    public void run() {
        while(true) {
            gun.push();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
