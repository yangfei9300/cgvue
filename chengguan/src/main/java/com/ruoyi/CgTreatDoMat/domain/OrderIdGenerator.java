package com.ruoyi.CgTreatDoMat.domain;

import java.time.Instant;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class OrderIdGenerator {
    private final Random random = new Random();
    private final AtomicLong counter = new AtomicLong(0);
    public synchronized String generateOrderId() {
        long timestamp = Instant.now().toEpochMilli();
        long randomNumber = random.nextInt(999); // 生成0到999之间的随机数
        long sequence = counter.incrementAndGet() % 1000; // 生成序列号，‌保证线程安全
        // 拼接生成订单编号
        return String.format("%d%03d%03d", timestamp, randomNumber, sequence);
    }

    public static void main(String[] args) {
        OrderIdGenerator generator = new OrderIdGenerator();
        for (int i = 0; i < 10; i++) {
            System.out.println(generator.generateOrderId());
        }
    }
}