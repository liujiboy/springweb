package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
	@Autowired
	private BookService bookService;
	@RequestMapping(value="/getBook.do")
	public Book getBook(String id)
	{
		return bookService.getBook(id);
	}
}
