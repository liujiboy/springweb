package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hello.domain.Book;
import hello.domain.Category;
import hello.mapper.BookMapper;
import hello.mapper.CategoryMapper;

@Service
public class BookService {
	@Autowired
	private BookMapper bookMapper;
	@Autowired
	private CategoryMapper categoryMapper;
	@Transactional //事务操作
	public boolean addBook(Long id,String name,String info,Long categoryId,String categoryCode,String categoryName)
	{
		Book book=new Book();
		book.setId(id);
		book.setName(categoryName);
		book.setCategoryId(categoryId);
		book.setInfo(info);
		Category c=new Category();
		c.setCode(categoryCode);
		c.setName(categoryName);
		c.setId(categoryId);
		categoryMapper.insertCategory(c); //先插入category
		bookMapper.insertBook(book); //再插入book
		return true;
	}
}
