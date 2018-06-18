package com.qing.thrift;

import generated.TestService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;  
import org.apache.thrift.protocol.TProtocol;  
import org.apache.thrift.transport.TSocket;  
import org.apache.thrift.transport.TTransport;  
import org.apache.thrift.transport.TTransportException;  
  
public class Client {  
    public static void main(String[] args) {  
        //配置服务端的请求信息  
        TTransport transport = new TSocket("127.0.0.1", 9090);  
        try {  
            transport.open();  
            TProtocol protocol = new TBinaryProtocol(transport);  
            TestService.Client client = new TestService.Client(protocol);
              
            //接口调用  
            String rs = client.test(123, "test");  
            //打印调用结果  
            System.out.println("java client:" + rs);  
            transport.close();  
        } catch (TTransportException e) {  
            e.printStackTrace();  
        } catch (TException e) {  
            e.printStackTrace();  
        }  
    }  
}