package com.practice.bankadvisor.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ScheduleTasks {
    private SimpMessagingTemplate template;

    @Autowired
    public ScheduleTasks(SimpMessagingTemplate template) {
        this.template = template;
    }

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        template.convertAndSend("/topic/schedule-task-1", "Hello " + LocalDateTime.now());
    }
}
