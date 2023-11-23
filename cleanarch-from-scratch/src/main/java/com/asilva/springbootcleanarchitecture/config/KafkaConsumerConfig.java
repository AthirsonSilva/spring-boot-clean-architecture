package com.asilva.springbootcleanarchitecture.config;

import static org.apache.kafka.clients.consumer.ConsumerConfig.AUTO_OFFSET_RESET_CONFIG;
import static org.apache.kafka.clients.consumer.ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG;
import static org.apache.kafka.clients.consumer.ConsumerConfig.GROUP_ID_CONFIG;
import static org.apache.kafka.clients.consumer.ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG;
import static org.apache.kafka.clients.consumer.ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG;

import java.util.HashMap;

import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.asilva.springbootcleanarchitecture.entrypoint.consumer.message.CustomerMessage;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {
	@Bean
	protected ConsumerFactory<String, CustomerMessage> consumerFactory() {
		HashMap<String, Object> props = new HashMap<>();
		props.put(BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		props.put(GROUP_ID_CONFIG, "cleanarch");
		props.put(KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		props.put(AUTO_OFFSET_RESET_CONFIG, "earliest");

		return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(),
				new JsonDeserializer<>(CustomerMessage.class));
	}

	@Bean
	protected ConcurrentKafkaListenerContainerFactory<String, CustomerMessage> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, CustomerMessage> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}
}