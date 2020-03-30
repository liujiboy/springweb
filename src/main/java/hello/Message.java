package hello;

public class Message implements MessageService {

	@Override
	public String getMessage() {
		
		return "Message:Hello world!";
	}

}
