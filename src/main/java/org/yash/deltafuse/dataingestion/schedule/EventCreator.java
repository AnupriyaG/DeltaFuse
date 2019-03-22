package org.yash.deltafuse.dataingestion.schedule;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EventCreator {

	private static final Logger LOG = LoggerFactory.getLogger(EventCreator.class);

	@Scheduled(fixedRate = 1000)
    public void create() {
        final LocalDateTime start = LocalDateTime.now();
        System.out.println("Event created!"+start);
    }
    
}
