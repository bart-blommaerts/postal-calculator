package be.bbconsulting.postalcalculator.events;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface EventChannel {

    String EVENT_IN = "eventIn";

    @Input(EVENT_IN)
    SubscribableChannel eventIn();
}

