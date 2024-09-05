package kafkaproducer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class KafkaConfig {
	@Bean
	public NewTopic provideNewTopic() {
		return new NewTopic("myTopicOne", 3, (short) 1);
	}

}
