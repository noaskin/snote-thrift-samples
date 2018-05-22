package com.thrift.example.server.hsha;

import org.apache.thrift.async.AsyncMethodCallback;

import java.util.concurrent.CountDownLatch;

class AsynCallback implements AsyncMethodCallback<Boolean> {
    private CountDownLatch latch;

    public AsynCallback(CountDownLatch latch) {
        this.latch = latch;
    }

    public void onComplete(Boolean response) {
        System.out.println("onComplete");
        try {
            // Thread.sleep(1000L * 1);
            System.out.println("AsynCall result =:" + response);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            latch.countDown();
        }
    }

    public void onError(Exception exception) {
        System.out.println("onError :" + exception.getMessage());
        latch.countDown();
    }
}