package com.example.utility;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TokenBucketAlgorithm {
    private int bucketSize;
    private int numberOfTokenAvailable;
    private int refillRate;

    private long intervalRefill;

    public TokenBucketAlgorithm(int bucketSize, int refillRate) {
        this.bucketSize = bucketSize;
        this.refillRate = refillRate;
        this.numberOfTokenAvailable = bucketSize;
        this.intervalRefill = refillRate/1000;

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);




        try {
            scheduler.scheduleAtFixedRate(this::refillToken, 0, intervalRefill, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized boolean tryConsumeToken() {
        if (numberOfTokenAvailable > 0) {
            numberOfTokenAvailable--;
            return true;
        } else {
            return false;
        }
    }

    private synchronized void refillToken() {
        if (numberOfTokenAvailable < bucketSize) {
            numberOfTokenAvailable++;
        }
    }


}
