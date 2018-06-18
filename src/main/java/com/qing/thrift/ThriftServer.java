package com.qing.thrift;

import generated.PersonService;
import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TTransportFactory;

/**
 * <p>****************************************************************************</p>
 * <p><b>Copyright © 2010-2017 Sanfangda team All Rights Reserved<b></p>
 * <ul style="margin:15px;">
 * <li>@description : com.qing.thrift</li>
 * <li>@version     : 1.0</li>
 * <li>@creation    : 2018年03月04日</li>
 * <li>@author     : fanrenqing</li>
 * </ul>
 * <p>****************************************************************************</p>
 */
public class ThriftServer {

    public static void main(String[] args) throws Exception {
        TNonblockingServerSocket serverSocket = new TNonblockingServerSocket(9090);
        THsHaServer.Args server = new THsHaServer.Args(serverSocket).minWorkerThreads(2).maxWorkerThreads(4);
        PersonService.Processor<PersonServiceImpl> processor = new PersonService.Processor<>(new PersonServiceImpl());

        server.protocolFactory(new TCompactProtocol.Factory());
        server.transportFactory(new TFramedTransport.Factory());
        server.processorFactory(new TProcessorFactory(processor));

        TServer tServer = new THsHaServer(server);
        System.out.println("Thrift Server Started!");
        tServer.serve();
    }
}
