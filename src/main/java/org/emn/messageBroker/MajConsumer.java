package org.emn.messageBroker;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;

public class MajConsumer extends MessageConsumer {

	public MajConsumer(String topic) {
		super(topic);
	}

	public MajConsumer() {
		super("maj");
	}

	public void listen() {
		while (true) {
			ConsumerRecords<String, String> records = consumer.poll(100);
			for (ConsumerRecord<String, String> record : records)
				// print the offset,key and value for the consumer records.
				System.out.printf("offset = %d, key = %s, value = %s\n", record.offset(), record.key(), record.value());
		}
	}

}
