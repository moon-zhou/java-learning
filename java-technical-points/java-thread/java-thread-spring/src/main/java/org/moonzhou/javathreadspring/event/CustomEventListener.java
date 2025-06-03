package org.moonzhou.javathreadspring.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CustomEventListener {
    @Async("taskExecutorMoon2")
    @EventListener
    public void onApplicationEvent(CustomEvent event) {
        log.info("Received custom event - {}", event.getMessage());
    }
}