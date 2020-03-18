package org.javacream.books.warehouse.eventconsumer;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Processor.class)
public class SimpleEventConsumer {

	@StreamListener(Processor.INPUT) public void handleEvent(Message<String> message) {
		System.out.println("Handling message " + message);
	}
}
