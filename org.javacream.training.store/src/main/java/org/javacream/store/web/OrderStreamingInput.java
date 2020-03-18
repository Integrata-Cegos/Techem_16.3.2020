package org.javacream.store.web;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface OrderStreamingInput {
	@Input
	SubscribableChannel  orderingInput();


}
