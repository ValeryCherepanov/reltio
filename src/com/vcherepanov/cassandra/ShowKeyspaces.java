package com.vcherepanov.cassandra;

import org.apache.cassandra.thrift.*;
import org.apache.thrift.protocol.*;
import org.apache.thrift.transport.*;

public class ShowKeyspaces {

    public static void main(String[] args) throws Exception {

        String host = "127.0.0.2сссZZ111";
        int port = 9160;


        System.out.println("Foo");
        TSocket socket = new TSocket(host, port);
        TTransport transport = new TFramedTransport(socket);
        TProtocol proto = new TBinaryProtocol(transport);
        transport.open();
        Cassandra.Client client = new Cassandra.Client(proto);
        System.out.println("version " + client.describe_version());
        System.out.println("partitioner "
                + client.describe_partitioner());
        System.out.println("cluster name "
                + client.describe_cluster_name());
        for (KsDef keyspace : client.describe_keyspaces()) {
            System.out.println("keyspace " + keyspace.getName());
        }
        transport.close();
    }
}

