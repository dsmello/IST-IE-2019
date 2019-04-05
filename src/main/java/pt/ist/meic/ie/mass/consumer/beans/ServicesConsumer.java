package pt.ist.meic.ie.mass.consumer.beans;


import org.springframework.web.bind.annotation.*;
import pt.ist.meic.ie.mass.util.KafkaEvent;
import pt.ist.meic.ie.mass.util.Response;
import pt.ist.meic.ie.mass.util.KafkaEventConsumer;

@RestController
@RequestMapping("/consumer")
public class ServicesConsumer {

    private KafkaEventConsumer eventconsumer = new KafkaEventConsumer();

    private int calls = 0;

    @GetMapping(produces = "application/json")
    public @ResponseBody String status(){

        String msg = "Was created: " + calls + " events";
        return new Response("info", msg).toJSON();
    }

    @GetMapping("/{topic}")
    public void complete(@PathVariable String topic){

        this.eventconsumer.consumeEvent(topic);
    }

}
