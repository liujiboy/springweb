package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.domain.Book;
import app.service.BookService;

@RestController
public class BookController {
	@Autowired
	private BookService bookService;
	@RequestMapping(value="/getBook.do")
	public Book getBook(String id)
	{
		return bookService.getBook(id);
	}
	@RequestMapping(value="/findBookByCategoryName.do")
	public List<Book> findBookByCategoryName(String name)
	{
		return bookService.findBookByCategoryName(name);
	}
}
