package hello;



import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.ModelAndView;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class IndexControllerTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	@Autowired
	private IndexController indexController;
	@Test
	public void testIndex() {
		ModelAndView mv=indexController.index("liuji");
		Assert.assertEquals("/welcome",mv.getViewName());
		Assert.assertEquals("liuji",mv.getModel().get("name"));
	}

}
