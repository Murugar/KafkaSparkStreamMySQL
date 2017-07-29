
package com.iqmsoft.spark.kafka.mysql.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import com.iqmsoft.spark.kafka.mysql.config.ConfigurationFactory;
import com.iqmsoft.spark.kafka.mysql.config.objects.Config;

import java.util.Properties;

public class Producer {
    private static final Config CONFIG = ConfigurationFactory.load();

    private final KafkaProducer<String, String> producer;

    public Producer() {
        StringBuilder builder = new StringBuilder();

        for (int i = 0, size = CONFIG.getProducer().getHosts().size(); i < size; i++) {
            builder.append(CONFIG.getProducer().getHosts().get(i));

            if (i < size - 1) {
                builder.append(",");
            }
        }

        final Properties props = new Properties();
        props.put("bootstrap.servers", builder.toString());
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", CONFIG.getProducer().getBatchSize());
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        producer = new KafkaProducer<>(props);
    }

    public void produce(String key, String data) {
        producer.send(new ProducerRecord<>(CONFIG.getProducer().getTopic(), key, data));
    }

    public void close() {
        producer.close();
    }
}