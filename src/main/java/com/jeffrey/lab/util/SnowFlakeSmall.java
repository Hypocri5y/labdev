package com.jeffrey.lab.util;

import org.springframework.stereotype.Component;

/**
 * @program: lab
 * @author: Jeffrey
 * @create: 2025-04-02 18:20
 * @description:
 **/
@Component
public class SnowFlakeSmall {

    /**
     * 起始时间戳，初始化后不可修改
     */
    private final long epoch = 1735689600000L;//2025-01-01 08:00:00

    /**
     * 每一部分所占位数（机器中心编码，序列号）
     */
    private final long workerIdBits = 5;
    private final long sequenceBits = 7;

    /**
     * 每一部分的最大值（机器中心编码，序列号）
     */
    private final long maxWorkerId = ~(-1L << workerIdBits);
    private final long maxSequence = ~(-1L << sequenceBits);

    /**
     * 每一部分的偏移（时间戳区域，机器中心区域）
     */
    private final long timestampShift = workerIdBits + sequenceBits;
    private final long workerIdShift = sequenceBits;

    /**
     * 机器进程编码，初始化后不可修改，取值范围: [0,31]
     * 默认设为1
     */
    private long workerId = 1l;

    /**
     * 序列号，取值范围: [0,4095]
     */
    private long sequence = 0L;

    /**
     * 上次执行生成 ID 方法的时间戳
     */
    private long lastTimestamp = -1L;

    /**
     * 雪花算法构造器（缩小版）
     *  workerId 数据中心编码 [0,31]
     */
    public SnowFlakeSmall() {
    }
    public SnowFlakeSmall(long workerId) {
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException("无效的 machineId，其范围应该在 0 - " + maxWorkerId);
        }
        this.workerId = workerId;
    }

    /**
     * 生成下一个唯一标识，其中：符号位 + 时间戳占 42 位
     * 1，雪花算法依赖服务器时间，如果时间发生回拨，抛异常
     * 2，每毫秒生成 maxSequence 个 id，如果超过则阻塞到下一毫秒
     */
    public synchronized long nextId() {
        long currTimestamp = timestampGen();
        if (currTimestamp < lastTimestamp) {
            String errMsg = String.format("服务器时间发生回拨 %d milliseconds", lastTimestamp - currTimestamp);
            throw new IllegalStateException(errMsg);
        }
        if (currTimestamp == lastTimestamp) {
            sequence = (sequence + 1) & maxSequence;
            if (sequence == 0L) {
                currTimestamp = waitNextMillis(currTimestamp);
            }
        } else {
            sequence = 0L;
        }
        lastTimestamp = currTimestamp;
        return (currTimestamp - epoch) << timestampShift | workerId << workerIdShift | sequence;
    }

    /**
     * 循环阻塞直到下一毫秒
     * @param currTimestamp 时间戳
     */
    private long waitNextMillis(long currTimestamp) {
        while (currTimestamp <= lastTimestamp) {
            currTimestamp = timestampGen();
        }
        return currTimestamp;
    }

    /**
     * 获取当前时间戳
     */
    private long timestampGen() {
        return System.currentTimeMillis();
    }

    public static void main(String[] args) {
//        SnowFlakeSmall snowFlakeSmall = new SnowFlakeSmall(1);
        SnowFlakeSmall snowFlakeSmall = new SnowFlakeSmall();
        long l = snowFlakeSmall.nextId();
        System.out.println(l);
    }
}