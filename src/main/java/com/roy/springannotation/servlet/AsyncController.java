package com.roy.springannotation.servlet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.UUID;
import java.util.concurrent.Callable;

@Controller
public class AsyncController {

    @ResponseBody
    @RequestMapping("/async01")
    public Callable<String> async01(){
        System.out.println("主线程Start");
        Callable<String> callable = new Callable<String>() {
            public String call() throws Exception {

                System.out.println("子线程Start");
                Thread.sleep(2000);

                System.out.println("子线程End");
                return "Callable<String> async01()";
            }
        };

        System.out.println("主线程End");
        return callable;
    }

    @ResponseBody
    @RequestMapping("/createOrder")
    public DeferredResult<Object> createOrder(){
        DeferredResult<Object> deferredResult = new DeferredResult<Object>((long) 3000,"create failed");

        DeferredResultQueue.save(deferredResult);

        return deferredResult;
    }

    //模拟从消息队列中获取，并执行业务逻辑
    @ResponseBody
    @RequestMapping("/create")
    public String create(){
        String orderId = UUID.randomUUID().toString();

        //将处理结果设置到DeferredResult中，这时真正的请求就会返回到客户端
        DeferredResultQueue.get().setResult(orderId);
        return "Success";
    }
}
