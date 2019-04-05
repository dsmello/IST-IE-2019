package producer;

import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.LongSerializer;
import org.apache.kafka.common.serialization.StringSerializer;

public class prducer_basic {

    public static void main(String[] args) {
        Properties kafkaProps = new Properties();
        kafkaProps.put("bootstrap.servers", "0.0.0.0:9092");
        kafkaProps.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        kafkaProps.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(kafkaProps);
//Fire-and-forget
        System.out.println("Fire-and-forget starting...");
        ProducerRecord <String, String> record = new ProducerRecord<String, String>("EXERCISE3", "Precision Products", " France");
        try {
            producer.send(record);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Fire-and-forget stopped.");
//Synchronous send
        System.out.println("Synchronous send starting...");
        ProducerRecord<String, String> record2 =
                new ProducerRecord <String, String>("EXERCISE3", "Precision Products", "France2");
        try {
            System.out.println("Result get =" + producer.send(record2).get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Synchronous stopped.");
    }
}
