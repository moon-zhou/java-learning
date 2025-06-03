package org.moonzhou.javathreadspring.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
 
@Service
public class EventPublishingService {
    private final ApplicationEventPublisher publisher;

    public EventPublishingService(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void publish(String message) {
        CustomEvent event = new CustomEvent(this, message);
        publisher.publishEvent(event);
    }
}