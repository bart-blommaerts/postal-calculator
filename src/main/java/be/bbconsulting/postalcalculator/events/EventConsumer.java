package be.bbconsulting.postalcalculator.events;


import be.bbconsulting.postal.events.avro.AvroEvent;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class EventConsumer {

    @StreamListener(EventChannel.EVENT_IN)
    public void onMessage(Message<AvroEvent> eventAvro) {
        var avroEvent = eventAvro.getPayload();

        System.out.println(avroEvent.getData());
        System.out.println(avroEvent.getEventUUID());
        System.out.println(avroEvent.getName());
    }
}



