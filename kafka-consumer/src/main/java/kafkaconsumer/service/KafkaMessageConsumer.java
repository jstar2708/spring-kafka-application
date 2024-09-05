package kafkaconsumer.service;

import com.jaideep.kafkacommon.dto.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageConsumer {
	private static final Logger logger = LoggerFactory.getLogger(KafkaMessageConsumer.class);

	@KafkaListener(topics = "topicOne", groupId = "con-grp-2")
	public void consumerOne(String message) {
		logger.info("Consumer consumed the message : " + message);
	}

	@KafkaListener(topics = "topicOne", groupId = "con-grp-2")
	public void consumerTwo(String message) {
		logger.info("Consumer consumed the message : " + message);
	}

	@KafkaListener(topics = "topicOne", groupId = "con-grp-2")
	public void consumerThree(String message) {
		logger.info("Consumer consumed the message : " + message);
	}

	@KafkaListener(topics = "myTopicOne", groupId = "con-grp-1")
	public void objectConsumerOne(Customer customer) {
		logger.info("Consumer consumed the message : " + customer.toString());
	}
}
