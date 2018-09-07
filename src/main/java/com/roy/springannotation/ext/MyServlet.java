package com.roy.springannotation.ext;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/async", asyncSupported = true)
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(final HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("主线程开始");

        final AsyncContext startAsync = req.startAsync();

        //业务逻辑开始异步执行
        startAsync.start(new Runnable() {
            public void run() {
                System.out.println("子线程开始");

                System.out.println("执行长时间业务");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                startAsync.complete();

                //获取异步请求上下文
                AsyncContext asyncContext = req.getAsyncContext();
                //获取相应并输出
                ServletResponse response = asyncContext.getResponse();
                try {
                    response.getWriter().write("Hello Async");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("子线程结束");
            }
        });

        //主线程结束后，便空闲了，放入线程池，供其他请求使用
        System.out.println("主线程结束");
    }
}
