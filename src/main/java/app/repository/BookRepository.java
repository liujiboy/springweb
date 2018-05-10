package app.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//https://docs.spring.io/spring-data/data-jpa/docs/current/reference/html/
import org.springframework.data.jpa.repository.Query;

import app.domain.Book;
public interface BookRepository extends JpaRepository<Book, String> {
	@Query("select book from Book as book where book.category.name=:name")
	List<Book> findByCategoryName(String name);

}
