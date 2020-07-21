package hello.mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import hello.Application;
import hello.domain.Book;
import hello.domain.BookCategory;
import hello.service.TestDataBase;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=Application.class)
public class BookMapperTest {
	@Autowired
	private BookMapper bookMapper;
	@Autowired
	private TestDataBase testDataBase;
	@Before
	public void setUp() throws Exception {
		
		testDataBase.prepareData();
	}

	@After
	public void tearDown() throws Exception {
		testDataBase.clearData();
	}


	@Test
	public void testGetBookById() {
		Book book=bookMapper.getBookById(1L);
		assertEquals(1L, book.getCategoryId().longValue());
		assertEquals("测试图书1",book.getName());
		assertEquals("测试图书1",book.getInfo());
	}

	@Test
	public void testInsertAndDeleteBook() {
		Book b=new Book();
		b.setId(4L);
		b.setCategoryId(1L);
		b.setInfo("测试图书4");
		b.setName("测试图书4");
		int v=bookMapper.insertBook(b);
		assertEquals(1,v);
		v=bookMapper.deleteById(4L);
		assertEquals(1,v);
	}

	@Test
	public void testGetBookCategory() {
		List<BookCategory> list=bookMapper.getBookCategory();
		assertEquals(3, list.size());
	}

}
