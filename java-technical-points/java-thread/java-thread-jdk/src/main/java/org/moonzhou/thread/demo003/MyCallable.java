package org.moonzhou.thread.demo003;

import java.util.concurrent.Callable;

class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "Thread via Callable返回结果";
    }
}