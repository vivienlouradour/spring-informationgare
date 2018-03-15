package org.emn.messageBroker;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;

public class CatalogueConsumer extends MessageConsumer {

	public CatalogueConsumer(String topic) {
		super(topic);
	}

	public CatalogueConsumer() {
		super("Catalogue");
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
