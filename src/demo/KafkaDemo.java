package demo;

import java.io.IOException;
import java.util.List;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import models.Product;
import models.properties.KafkaProperties;
import parse.ParseData;

public class KafkaDemo {
	public static void main(String[] args) throws IOException {
		ParseData parse = new ParseData();
		List<Product> list = parse.getData().getListProducts();
		
		Producer<String, Product> producer = new KafkaProducer<String, Product>(KafkaProperties.getInstance());
		
		list.forEach(l -> producer.send(new ProducerRecord<String, Product>("hello-kafka", "key", l)));
		producer.send(new ProducerRecord<String, Product>("hello-kafka", "key", list.get(0)));
		
		System.out.println("successfully!");
		producer.close();
		
	}
}
