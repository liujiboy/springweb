


import org.springframework.web.client.RestTemplate;

import domain.College;



public class TestCollegeController {

	public static void main(String[] args) {
		RestTemplate rest=new RestTemplate();
		Boolean ret=rest.getForObject("http://127.0.0.1:8080/springweb/college/add", Boolean.class);
		System.out.println(ret);
		College college=rest.getForObject("http://127.0.0.1:8080/springweb/college/{id}", College.class, "1");
		System.out.printf("id=%s,name=%s\n",college.getId(),college.getName());
	}

}
