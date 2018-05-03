package hello;

import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;

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
	public Book getBook(String id)
	{
		return bookRepository.findById(id).get();
	}
	
}
