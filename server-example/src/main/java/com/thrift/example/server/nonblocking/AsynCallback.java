package com.thrift.example.server.nonblocking;

import com.thrift.example.server.TestService;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;

import java.util.concurrent.CountDownLatch;

public class AsynCallback implements AsyncMethodCallback<TestService.AsyncClient.getBool_call> {
    private CountDownLatch latch;

    public AsynCallback(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void onComplete(TestService.AsyncClient.getBool_call response) {
        System.out.println("onComplete");
        try {
            //TimeUnit.SECONDS.sleep(10);
            System.out.println("AsynCall result =:" + response.getResult());
        } catch (TException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            latch.countDown();
        }
    }

    @Override
    public void onError(Exception exception) {
        System.out.println("onError :" + exception.getMessage());
        latch.countDown();
    }
}