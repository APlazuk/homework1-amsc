package pl.aplazuk.ms1.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.endpoint.event.RefreshEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
public class ConfigServerPropertiesUpdate {
    Logger logger = LoggerFactory.getLogger(ConfigServerPropertiesUpdate.class);

    private final ApplicationEventPublisher eventPublisher;

    public ConfigServerPropertiesUpdate(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @Scheduled(cron = "0 0/15 * * * ?")
    public void updateConfigServerProperties() {
        RefreshEvent refreshEvent = new RefreshEvent(this, "RefreshEvent", "Refreshing config server properties");
        eventPublisher.publishEvent(refreshEvent);
        logger.info("Refresh event has been published: {}", refreshEvent.getEventDesc());
    }
}
