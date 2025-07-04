package org.moonzhou.javathreadspring.virtualthread;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AsyncVirtualThreadService {

    @Async("virtualThread")
    public void asyncTask() {
        log.info("Async task in virtual thread: {}",
                Thread.currentThread().isVirtual());
    }
}