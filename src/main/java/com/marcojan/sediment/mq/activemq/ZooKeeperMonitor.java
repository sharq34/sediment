package com.marcojan.sediment.mq.activemq;

import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class ZooKeeperMonitor{

    LinkedBlockingQueue<String> q = new LinkedBlockingQueue<String>();
    private static Boolean IS_LOCKED = false;
    String master = null;

    public ZooKeeperMonitor(){

    }

//    private void selectorOfMaster(){
//
//        if(!master.isAvailable) {
//
//            while (!IS_LOCKED) {
//                String serverName = q.peek();
//                Boolean flag = zk.create(serverName);
//                if (!flag) continue;
//                else
//                    master = serverName;
//            }
//        }
//    }

    // check

}
