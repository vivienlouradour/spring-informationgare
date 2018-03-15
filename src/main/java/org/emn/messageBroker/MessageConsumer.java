package org.emn.messageBroker;

import java.util.Properties;

import org.apache.kafka.clients.consumer.KafkaConsumer;

public abstract class MessageConsumer implements Runnable {

	KafkaConsumer<String, String> consumer;

	public MessageConsumer(String topic) {
		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9092");
		props.put("group.id", "test");
		props.put("enable.auto.commit", "true");
		props.put("auto.commit.interval.ms", "1000");
		props.put("session.timeout.ms", "30000");
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		consumer = new KafkaConsumer<String, String>(props);
	}

	abstract public void listen();

	public void run() {
		this.listen();
	}
}
