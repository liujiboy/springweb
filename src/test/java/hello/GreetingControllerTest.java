package hello;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class GreetingControllerTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	@Autowired
	private GreetingController greetingController;
	@Test
	public void testGreeting() {
		Greeting greeting=greetingController.greeting("liuji");
		Assert.assertEquals(1, greeting.getId());
		Assert.assertEquals("Hello, liuji!", greeting.getContent());
		greeting=greetingController.greeting("abc");
		Assert.assertEquals(2, greeting.getId());
		Assert.assertEquals("Hello, abc!", greeting.getContent());
	}

}
