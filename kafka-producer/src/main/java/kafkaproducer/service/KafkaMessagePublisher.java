package kafkaproducer.service;

import com.jaideep.kafkacommon.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaMessagePublisher {
	@Autowired
	private KafkaTemplate<String, Object> template;

	public void sendMessageToTopic(String message) {
		CompletableFuture<SendResult<String, Object>> future = template.send("mtop", message);
		future.whenComplete((result, ex) -> {
			if (ex == null) {
				System.out.printf("Sent message=[%s] with offset=[%s]\n", message, result.getRecordMetadata().offset());
			} else {
				System.out.printf("Unable to send message=[%s] due to : %s\n", message, ex.getMessage());

			}
		});
	}

	public void sendMessageToTopicWithSpecificPartition(String message) {
		CompletableFuture<SendResult<String, Object>> future = template.send("mtop", 1, message, message);
		future.whenComplete((result, ex) -> {
			if (ex == null) {
				System.out.printf("Sent message=[%s] with offset=[%s]\n", message, result.getRecordMetadata().offset());
			} else {
				System.out.printf("Unable to send message=[%s] due to : %s\n", message, ex.getMessage());

			}
		});
	}



	public void sendObjectToTopic(Customer customer) {
		try {
			CompletableFuture<SendResult<String, Object>> future = template.send("myTopicOne", customer);
			future.whenComplete((res, ex) -> {
				if (ex == null) {
					System.out.printf("Sent message=[%s] with offset=[%s]", customer.toString(),
													res.getRecordMetadata().offset());
				} else {
					System.out.printf("Unable to send message=[%s] due to : [%s]", customer.toString(), ex
													.getMessage());
				}
			});
		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
			System.out.println("Details: " + e.getCause().getMessage());
		}
	}

}
