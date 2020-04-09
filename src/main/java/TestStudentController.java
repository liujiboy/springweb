

import org.springframework.web.client.RestTemplate;

public class TestStudentController {
	public static void main(String[] args) {
		RestTemplate rest=new RestTemplate();
		rest.postForObject("http://127.0.0.1:8080/springweb/student/add/{id}/{name}/{age}/{collegeId}", null, Boolean.class, "1", "foo1", 10, "1");
		rest.postForObject("http://127.0.0.1:8080/springweb/student/add/{id}/{name}/{age}/{collegeId}", null, Boolean.class, "2", "foo2", 11, "1");
		rest.postForObject("http://127.0.0.1:8080/springweb/student/add/{id}/{name}/{age}/{collegeId}", null, Boolean.class, "3", "foo3", 12, "1");
		rest.postForObject("http://127.0.0.1:8080/springweb/student/add/{id}/{name}/{age}/{collegeId}", null, Boolean.class, "4", "bar1", 13, "2");
		String json=rest.getForObject("http://127.0.0.1:8080/springweb/student/all", String.class);
		System.out.println(json);
	}
}
