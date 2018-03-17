package org.emn.messageBroker;

import java.io.IOException;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.beans.factory.annotation.Autowired;

import imta.fila1.spring.informationgare.modele.Course;
import imta.fila1.spring.informationgare.modele.CourseService;

public class CatalogueConsumer extends MessageConsumer {

	@Autowired
	private CourseService courseService;

	public CatalogueConsumer(String topic) {
		super(topic);
	}

	public CatalogueConsumer() {
		super("Catalogue");
	}

	public void listen() {
		while (true) {
			ConsumerRecords<String, String> records = consumer.poll(1);
			for (ConsumerRecord<String, String> record : records) {
				// print the offset,key and value for the consumer records.
				System.out.printf("offset = %d, key = %s, value = %s\n", record.offset(), record.key(), record.value());
				try {
					Course obj = mapper.readValue(record.value(), Course.class);
					System.out.println(obj);
					courseService.addCourse(obj);
					System.out.println("Ajout de la course OK");

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
