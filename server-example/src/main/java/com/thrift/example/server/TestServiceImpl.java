package com.thrift.example.server;

import org.apache.thrift.TException;

import java.nio.ByteBuffer;

public class TestServiceImpl implements TestService.Iface {
    @Override
    public void getVoid(Test test) throws TException {
        System.out.println("TestServiceImpl.getVoid() + " + test);
    }

    @Override
    public boolean getBool(Test test) throws TException {
        System.out.println("TestServiceImpl.getBool() + " + test.isBool_());
        return test.isBool_();
    }

    @Override
    public byte getByte(Test test) throws TException {
        System.out.println("TestServiceImpl.getByte() + " + test.getByte_());
        return test.getByte_();
    }

    @Override
    public short getI16(Test test) throws TException {
        System.out.println("TestServiceImpl.getI16() + " + test.getI16_());
        return test.getI16_();
    }

    @Override
    public int getI32(Test test) throws TException {
        System.out.println("TestServiceImpl.getI32() + " + test.getI32_());
        return test.getI32_();
    }

    @Override
    public long getI64(Test test) throws TException {
        System.out.println("TestServiceImpl.getI64() + " + test.getI64_());
        return test.getI64_();
    }

    @Override
    public double getDouble(Test test) throws TException {
        System.out.println("TestServiceImpl.getDouble() + " + test.getDouble_());
        return test.getDouble_();
    }

    @Override
    public String getString(Test test) throws TException {
        System.out.println("TestServiceImpl.getString() + " + test.getString_());
        return test.getString_();
    }

    @Override
    public ByteBuffer getBinary(Test test) throws TException {
        System.out.println("TestServiceImpl.getBinary() + " + test.getBinary_());
        return ByteBuffer.wrap(test.getBinary_());
    }
}
