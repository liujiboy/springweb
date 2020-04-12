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
public class MathControllerTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	@Autowired
	private MathController mathController;
	@Test
	public void testAdd() {
		double result=mathController.add(1, 2);
		Assert.assertEquals(3,result,0.000001);
	}

	@Test
	public void testMul() {
		double result=mathController.mul(2,3);
		Assert.assertEquals(6,result,0.000001);
	}

	@Test
	public void testSin() {
		double result=mathController.sin(Math.PI/4);
		Assert.assertEquals(Math.sin(Math.PI/4),result,0.000001);
	}

}
