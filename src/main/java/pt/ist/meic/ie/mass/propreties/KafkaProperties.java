package pt.ist.meic.ie.mass.propreties;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;

public class KafkaProperties {

    private Properties kafkaProps = new Properties();
    private KafkaProducer<String, String> producer;

    public KafkaProperties() {
        this.kafkaProps.put("bootstrap.servers", "0.0.0.0:9092");
        this.kafkaProps.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        this.kafkaProps.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        this.producer = new KafkaProducer<String, String>(kafkaProps);
    }


    public KafkaProducer<String, String> getProducer(){
        return this.producer;
    }
}
