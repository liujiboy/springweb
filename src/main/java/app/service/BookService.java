package app.service;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.domain.Book;
import app.repository.BookRepository;
import app.repository.CategoryRepository;

@Service
public class BookService {
//	private HibernateTemplate ht;
//	private SessionFactory hibernateFactory;
//
//	  @Autowired
//	  public void SomeService(EntityManagerFactory factory) {
//	    if(factory.unwrap(SessionFactory.class) == null){
//	      throw new NullPointerException("factory is not a hibernate factory");
//	    }
//	    this.hibernateFactory = factory.unwrap(SessionFactory.class);
//	    ht=new HibernateTemplate(hibernateFactory);
//	  }
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	public Book getBook(String id)
	{
		
		return bookRepository.findById(id).get();
	}
	@Transactional
	public void addBook(String id,String name,double price,String des,String image,String categroyId)
	{
		Book book=new Book();
		book.setId(id);
		book.setName(name);
		book.setPrice(price);
		book.setDes(des);
		book.setImage(image);
		book.setCategory(categoryRepository.getOne(categroyId));
		bookRepository.save(book);
	}
	public void initBooks()
	{
		if(!bookRepository.existsById("b001"))
		{
			addBook("b001","三国演义",20,"三国历史XXX","","001");
		}
		if(!bookRepository.existsById("b002"))
		{
			addBook("b002","红楼梦",30,"XXXXXX","","001");
		}
		if(!bookRepository.existsById("b003"))
		{
			addBook("b003","水浒传",40,"XXXXX","","001");
		}
		if(!bookRepository.existsById("b004"))
		{
			addBook("b004","史记",40,"史马迁史记","","002");
		}
		if(!bookRepository.existsById("b005"))
		{
			addBook("b005","C++ Primer",40,"C++书籍","","003");
		}
	}
	public List<Book> findBookByCategoryName(String name) {
		return bookRepository.findByCategoryName(name);
	}
	
}
