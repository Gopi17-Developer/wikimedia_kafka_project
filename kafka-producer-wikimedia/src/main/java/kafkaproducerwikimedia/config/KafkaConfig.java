package kafkaproducerwikimedia.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

	@Bean
	public NewTopic topic() {
		
		//creating a kafka topic
		return TopicBuilder
				.name("Wikimedia_Recent_change")
				.build();
	}
}
