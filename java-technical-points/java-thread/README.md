## java thread

该项目为全栈课程面向前端工程师的Java 线程相关的实操案例。


### java thread spring
#### 压测
```shell
# 基本语法：ab -n 请求总数 -c 并发数 [目标URL]
# 示例：对 http://localhost:8080/start-async2 进行压测，1000个请求，并发数为10
ab -n 1000 -c 10 http://localhost:8080/start-async2
ab -n 10000 -c 100 http://localhost:8080/start-async2
```

配合 `jvisualvm` 进行线程可观测性测试，实际生产可能会结合其他工具比如 `Prometheus`。

同时 `jvisualvm` 可以看到 `SpirngBoot` 进程，可以测试 `kill -9`。