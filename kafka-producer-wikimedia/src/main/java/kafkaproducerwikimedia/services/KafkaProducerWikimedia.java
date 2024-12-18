package kafkaproducerwikimedia.services;

import java.net.URI;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.launchdarkly.eventsource.EventSource;
import com.launchdarkly.eventsource.EventHandler;

@Service
public class KafkaProducerWikimedia {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducerWikimedia.class);

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    public void publishWikimediaRecentChange() throws InterruptedException {
        String topicName = "Wikimedia_Recent_change";

        // Create EventHandler object
        EventHandler eventHandler = new WikimediaChangesHandler(kafkaTemplate, topicName);

        // URL for the Wikimedia stream
        String url = "https://stream.wikimedia.org/v2/stream/recentchange";

        // Build EventSource
        EventSource eventSource = new EventSource.Builder(eventHandler, URI.create(url)).build();

        // Start the EventSource
        eventSource.start();

        // Keep the application running for 10 minutes
        TimeUnit.MINUTES.sleep(10);

        // Stop the EventSource after the sleep
        eventSource.close();
    }
}
