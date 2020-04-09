

import org.springframework.web.client.RestTemplate;

public class TestDelete {

	public static void main(String[] args) {
		RestTemplate rest=new RestTemplate();
		rest.delete("http://127.0.0.1:8080/springweb/college/delete");
	}

}
