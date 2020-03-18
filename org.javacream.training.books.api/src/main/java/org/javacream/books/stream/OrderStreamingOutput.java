package org.javacream.books.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface OrderStreamingOutput {
	
	
	@Output MessageChannel orderingOutput();
}
