package pt.ist.meic.ie.mass.producer.beans;


import org.springframework.web.bind.annotation.*;
import pt.ist.meic.ie.mass.util.KafkaEvent;
import pt.ist.meic.ie.mass.util.KafkaEventProducer;
import pt.ist.meic.ie.mass.util.Response;

@RestController
@RequestMapping("/webservice")
public class Services {

    private KafkaEventProducer eventProducer = new KafkaEventProducer();

    private int calls = 0;

    @GetMapping(produces = "application/json")
    public @ResponseBody String status(){

        String msg = "Was created: " + calls + " events";
        return new Response("info", msg).toJSON();
    }

    @RequestMapping("/new")
    @PostMapping
    public String newEventeOnKafka(@RequestBody KafkaEvent kafkaEvent){

        this.calls+=1;
        eventProducer.generateEvent(kafkaEvent.getTopic(), kafkaEvent.getKey(), kafkaEvent.getValue());
        String msg = "The event was create: " + kafkaEvent.getKey();
        return new Response("feedback", msg).toJSON();
    }

}
