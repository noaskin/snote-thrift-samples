package com.thrift.example.server.nonblocking;

import com.thrift.example.server.TestService;
import com.thrift.example.server.TestServiceImpl;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TTransportException;

public class ThriftServer {

    public static void main(String[] args) {
        try {
            // 设置服务器端口
            TNonblockingServerSocket serverTransport = new TNonblockingServerSocket(9090);
            // 设置二进制协议工厂
            TBinaryProtocol.Factory protocolFactory = new TBinaryProtocol.Factory();
            // 处理器关联业务实现
            TestService.Processor<TestService.Iface> processor = new TestService.Processor<TestService.Iface>(
                    new TestServiceImpl());
            TNonblockingServer.Args re = new TNonblockingServer.Args(serverTransport)
                    .processor(processor)
                    .protocolFactory(protocolFactory);
            TServer server = new TNonblockingServer(re);
            System.out.println("开启thrift服务器，监听端口：9090");
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }

}
