package pt.ist.meic.ie.mass.util;

import org.apache.kafka.clients.producer.ProducerRecord;

import pt.ist.meic.ie.mass.propreties.KafkaProperties;

public class KafkaEventProducer {

    private KafkaProperties kafkaProperties = new KafkaProperties();

    public KafkaEventProducer (){}

    public void generateEvent(String topic, String key, String value){
        ProducerRecord <String, String> record = new ProducerRecord<>(topic, key, value);

        // TODO => Remove the try catch later;

        try {
            this.kafkaProperties.getProducer().send(record);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
