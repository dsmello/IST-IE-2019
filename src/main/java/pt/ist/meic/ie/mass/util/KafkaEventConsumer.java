package pt.ist.meic.ie.mass.util;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import pt.ist.meic.ie.mass.propreties.KafkaPropertiesConsumer;

import java.util.Collections;

public class KafkaEventConsumer {

    private KafkaPropertiesConsumer kafkaProperties = new KafkaPropertiesConsumer();

    public KafkaEventConsumer() {
    }

    public void consumeEvent(String topic) {
        this.kafkaProperties.getConsumer().subscribe(Collections.singletonList(topic));

        try {
            while (true) {

                ConsumerRecords<String, String> records = this.kafkaProperties.getConsumer().poll(100);
                for (ConsumerRecord<String, String> record : records) {
                    System.out.printf("topic = %s, partition = %s, offset = %d,type = %s, msg = %s\n",
                            record.topic(),
                            record.partition(),
                            record.offset(),
                            record.key(),
                            record.value());
                }
            }
        } finally {
            this.kafkaProperties.getConsumer().close();
        }
    }

}
