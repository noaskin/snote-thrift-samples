package com.thrift.example.server.nonblocking;

import com.thrift.example.server.Test;
import com.thrift.example.server.TestService;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.async.TAsyncClientManager;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.TNonblockingSocket;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class ThriftClient {
    public static void main(String[] args) {
        try {
            TProtocolFactory protocolFactory = new TBinaryProtocol.Factory();
            TAsyncClientManager clientManager = new TAsyncClientManager();
            TNonblockingSocket transport = new TNonblockingSocket("localhost", 9090);
            TestService.AsyncClient client = new TestService.AsyncClient(protocolFactory, clientManager, transport);

            Test test = new Test();
            test.setBool_(true);
            test.setByte_((byte) 1);
            test.setI16_((short) 2);
            test.setI32_(3);
            test.setI64_(4L);
            test.setDouble_(5.0);
            test.setString_("abc");
            test.setBinary_("abc".getBytes());

            CountDownLatch latch = new CountDownLatch(1);
            client.getBool(test, new AsynCallback(latch));

            boolean wait;
            try {
                wait = latch.await(1, TimeUnit.SECONDS);
                System.out.println("latch.await =:" + wait);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            transport.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        }
    }

}
