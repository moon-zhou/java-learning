package org.moonzhou.javathreadspring.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
@RequestMapping("/event")
public class EventController {
    @Autowired
    private EventPublishingService eventPublishingService;
    
    @GetMapping("/publish")
    public String publishEvent() {
        eventPublishingService.publish("Hello, this is a custom event!");
        return "Event published.";
    }
}