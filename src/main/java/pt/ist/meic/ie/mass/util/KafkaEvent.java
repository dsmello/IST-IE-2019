package pt.ist.meic.ie.mass.util;

public class KafkaEvent {

    private String topic;
    private String key;
    private String value;

    public KafkaEvent() {

    }

    public String getTopic() {
        return topic;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
