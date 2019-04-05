package pt.ist.meic.ie.mass.propreties;

import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Properties;

public class KafkaPropertiesConsumer {

    private Properties kafkaProps = new Properties();
    private KafkaConsumer<String, String> consumer;

    public KafkaPropertiesConsumer() {
        this.kafkaProps.put("bootstrap.servers", "0.0.0.0:9092");
        this.kafkaProps.put("group.id", "CountryCounter");
        this.kafkaProps.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        this.kafkaProps.put("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
        this.consumer = new KafkaConsumer<>(this.kafkaProps);
    }

    public KafkaConsumer getConsumer(){
        return this.consumer;
    }
}
