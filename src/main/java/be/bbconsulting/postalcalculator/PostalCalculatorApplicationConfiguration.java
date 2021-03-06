package be.bbconsulting.postalcalculator;

import be.bbconsulting.postalcalculator.events.EventChannel;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamMessageConverter;
import org.springframework.cloud.stream.schema.avro.AvroSchemaMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.util.MimeType;

@Configuration
@EnableBinding(EventChannel.class)
public class PostalCalculatorApplicationConfiguration {

    @Bean
    @StreamMessageConverter
    public MessageConverter eventMessageConverter() {
        var avroSchemaMessageConverter = new AvroSchemaMessageConverter(MimeType.valueOf("avro/bytes"));
        avroSchemaMessageConverter.setSchemaLocation(new ClassPathResource("avro/Event.avsc"));
        return avroSchemaMessageConverter;
    }
}