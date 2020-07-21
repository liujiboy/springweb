package hello.controller;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import hello.Application;
import hello.domain.Book;
import hello.domain.BookCategory;
import hello.service.TestDataBase;
@RunWith(SpringRunner.class)
@SpringBootTest(classes=Application.class,webEnvironment = WebEnvironment.DEFINED_PORT)
public class BookControllerTest {

	@Autowired
	private TestDataBase testDataBase;

	@Value("${server.port}")
	private int port;
	@Value("${server.servlet.context-path}")
	private String contextPath;

	private String urlBase;

	private TestRestTemplate restTemplate=new TestRestTemplate();

	@Before
	public void setUp() throws Exception {
		testDataBase.prepareData();
		this.urlBase = String.format("http://localhost:%d/%s/", port, contextPath);
	}

	@After
	public void tearDown() throws Exception {
		testDataBase.clearData();
	
	}

	@Test
	public void testGetBookById() {
		ResponseEntity<Book> response = this.restTemplate.getForEntity(this.urlBase + "/getBookById?id={id}", Book.class, 1L);
		Book book = response.getBody();
		assertEquals(1L, book.getCategoryId().longValue());
		assertEquals("测试图书1", book.getName());
		assertEquals("测试图书1", book.getInfo());
	}



	@Test
	public void testGetBookCategory() {
		ResponseEntity<List> response = this.restTemplate.getForEntity(this.urlBase + "/getBookCategory",List.class);
		List<BookCategory> list=response.getBody();
		assertEquals(3, list.size());
	}

	
}
