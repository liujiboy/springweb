package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hello.domain.Book;
import hello.domain.Category;
import hello.mapper.BookMapper;
import hello.mapper.CategoryMapper;

@Service
public class TestDataBase {
	@Autowired
	private BookMapper bookMapper;
	@Autowired
	private CategoryMapper categoryMapper;
	@Transactional
	public void prepareData()
	{
		Category c=new Category();
		c.setId(1L);
		c.setName("文学");
		c.setCode("100");
		categoryMapper.insertCategory(c);
		c.setId(2L);
		c.setName("历史");
		c.setCode("101");
		categoryMapper.insertCategory(c);
		Book b=new Book();
		b.setId(1L);
		b.setCategoryId(1L);
		b.setInfo("测试图书1");
		b.setName("测试图书1");
		bookMapper.insertBook(b);
		b.setId(2L);
		b.setCategoryId(2L);
		b.setInfo("测试图书2");
		b.setName("测试图书2");
		bookMapper.insertBook(b);
		b.setId(3L);
		b.setCategoryId(1L);
		b.setInfo("测试图书3");
		b.setName("测试图书3");
		bookMapper.insertBook(b);
	}
	@Transactional
	public void clearData()
	{
		bookMapper.deleteAll();
		categoryMapper.deleteAll();
	}
}
