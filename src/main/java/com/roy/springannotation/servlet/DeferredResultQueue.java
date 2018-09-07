package com.roy.springannotation.servlet;

import org.springframework.web.context.request.async.DeferredResult;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

//模拟消息队列
public class DeferredResultQueue {
    private static Queue<DeferredResult<Object>> queue = new ConcurrentLinkedQueue<DeferredResult<Object>>();

    //下单加入队列
    public static void save(DeferredResult<Object> result){
        queue.add(result);
    }

    public static DeferredResult<Object> get(){
        return queue.poll();
    }
}
