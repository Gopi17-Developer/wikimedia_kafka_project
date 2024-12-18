package kafkaproducerwikimedia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import kafkaproducerwikimedia.services.KafkaProducerWikimedia;

@SpringBootApplication
public class KafkaProducerWikimediaApplication implements CommandLineRunner{
	public static void main(String[] args) {
		
		SpringApplication.run(KafkaProducerWikimediaApplication.class);
	}

	@Autowired
	private KafkaProducerWikimedia kafkaProducerWikimedia;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		kafkaProducerWikimedia.publishWikimediaRecentChange();
	}
}
