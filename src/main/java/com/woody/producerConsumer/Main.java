package com.woody.producerConsumer;

/**
 *
 *
 * @author wudih
 * @date 2019/5/7 11:12
 * @since 1.0.0
 */
public class Main {
    public static void main(String[] args) {
        Gun gun = new Gun();
        Thread producer = new Thread(new Producer(gun));
        Thread consumer = new Thread(new Consumer(gun));
        producer.start();
        consumer.start();
    }
}
