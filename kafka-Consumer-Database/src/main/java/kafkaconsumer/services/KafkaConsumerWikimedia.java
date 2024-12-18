package kafkaconsumer.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import kafkaconsumer.models.Wikimediadata;
import kafkaconsumer.repository.WikimediaDataRepository;

@Service
public class KafkaConsumerWikimedia {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerWikimedia.class);
	@Autowired
	private WikimediaDataRepository wikimediaDataRepository;
	
	@KafkaListener(topics = "Wikimedia_Recent_change",groupId = "wikimedia")
	public void wikimediaConsumeChange(String eventMessage) {
		
		LOGGER.info(String.format("event message is: %s", eventMessage));
		
		Wikimediadata wikimediadata = new Wikimediadata();
		wikimediadata.setWikimediaEventData(eventMessage);
		
		wikimediaDataRepository.save(wikimediadata);
	}
}
