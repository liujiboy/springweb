package hello.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hello.BookService;
import hello.domain.Book;
import hello.domain.BookCategory;
import hello.mapper.BookMapper;

@RestController
public class BookController {
	@Autowired
	private BookMapper bookMapper;
	@Autowired
	private BookService bookService;
	
	@RequestMapping(value="/getBookById")
	public Book getBookById(Long id)
	{
		return bookMapper.getBookById(id); //直接在controller中方位数据库是不推荐的，不过这里只是为了测试一下Mybatis是否能够正确工作
	}
	@RequestMapping(value="/insertBook")
	public int insertBook(Book book)
	{
		return bookMapper.insertBook(book);
	}
	@RequestMapping(value="/getBookCategory")
	public List<BookCategory> getBookCategory()
	{
		return bookMapper.getBookCategory();
	}
	@RequestMapping(value="/addBook")
	//addBook?id=5&name=试一下&info=试一下&categoryId=3&categoryCode=004&categoryName=计算机
	public boolean addBook(Long id,String name,String info,Long categoryId,String categoryCode,String categoryName)
	{
		return bookService.addBook(id, name, info, categoryId, categoryCode, categoryName);
	}
	
}
