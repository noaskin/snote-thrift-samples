package com.thrift.example.server.hsha;

import com.thrift.example.server.TestService;
import com.thrift.example.server.TestServiceImpl;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TTransportException;
import org.apache.thrift.transport.TTransportFactory;

public class ThriftServer {

    public static void main(String[] args) {
        try {
            TNonblockingServerSocket serverTransport = new TNonblockingServerSocket(9090);
            TTransportFactory transportFactory = new TFramedTransport.Factory();
            TBinaryProtocol.Factory protocolFactory = new TBinaryProtocol.Factory();
            TestService.Processor<TestService.Iface> processor = new TestService.Processor<TestService.Iface>(
                    new TestServiceImpl());
            THsHaServer.Args arg = new THsHaServer.Args(serverTransport)
                    .processor(processor)
                    .transportFactory(transportFactory)
                    .protocolFactory(protocolFactory);
            TServer server = new THsHaServer(arg);
            System.out.println("开启thrift服务器，监听端口：9090");
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }

}
