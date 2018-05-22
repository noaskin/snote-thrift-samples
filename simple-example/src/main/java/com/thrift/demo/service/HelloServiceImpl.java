package com.thrift.demo.service;

import org.apache.thrift.TException;

public class HelloServiceImpl implements HelloService.Iface {

    public int sayInt(int param) throws TException {
        System.out.println("say int :" + param);
        return param;
    }

    public String sayString(String param) throws TException {
        System.out.println("say string :" + param);
        return param;
    }

    public boolean sayBoolean(boolean param) throws TException {
        System.out.println("say boolean :" + param);
        return param;
    }
    public void sayVoid() throws TException {
        System.out.println("say void ...");
    }
}
