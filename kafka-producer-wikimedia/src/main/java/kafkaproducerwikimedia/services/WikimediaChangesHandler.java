package kafkaproducerwikimedia.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;

public class WikimediaChangesHandler implements EventHandler{

	private static final Logger LOGGER = LoggerFactory.getLogger(WikimediaChangesHandler.class);
	
	
	KafkaTemplate<String, String> kafkaTemplate;
	private String topic;
	
	/**
	 * @param kafkaTemplate
	 * @param topic
	 */
	public WikimediaChangesHandler(KafkaTemplate<String, String> kafkaTemplate, String topic) {
		this.kafkaTemplate = kafkaTemplate;
		this.topic = topic;
	}

	/**
	 * @return the kafkaTemplate
	 */
	public KafkaTemplate<String, String> getKafkaTemplate() {
		return kafkaTemplate;
	}

	/**
	 * @param kafkaTemplate the kafkaTemplate to set
	 */
	public void setKafkaTemplate(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	/**
	 * @return the topic
	 */
	public String getTopic() {
		return topic;
	}

	/**
	 * @param topic the topic to set
	 */
	public void setTopic(String topic) {
		this.topic = topic;
	}

	@Override
	public void onOpen() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClosed() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMessage(String event, MessageEvent messageEvent) throws Exception {
		// TODO Auto-generated method stub
		//when ever change occure
		LOGGER.info(String.format("event data is: %s",messageEvent.getData()));
		
		//use kafka template to send event
		
		kafkaTemplate.send(topic, messageEvent.getData());
		
	}

	@Override
	public void onComment(String comment) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onError(Throwable t) {
		// TODO Auto-generated method stub
		
	}

}
