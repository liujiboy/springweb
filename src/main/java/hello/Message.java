package hello;

import org.springframework.stereotype.Component;

@Component("message")
public class Message implements MessageService {

	@Override
	public String getMessage() {
		
		return "Message:Hello world!";
	}

}
