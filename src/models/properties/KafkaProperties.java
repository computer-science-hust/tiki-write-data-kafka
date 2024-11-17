package models.properties;

import java.util.Properties;

import org.apache.kafka.common.serialization.StringSerializer;

import models.serializer.ProductSerializer;

public class KafkaProperties {
	/**
	 * Configuration parameter for kafka
	 * @return
	 */
	public static Properties getInstance() {
		Properties prop = new Properties();
		prop.put("bootstrap.servers", "localhost:9092");
		prop.put("key.serializer", StringSerializer.class);
		prop.put("value.serializer", ProductSerializer.class);
		
		return prop;
	}
}
