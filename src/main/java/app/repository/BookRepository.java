package app.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.domain.Book;
//https://docs.spring.io/spring-data/data-jpa/docs/current/reference/html/
public interface BookRepository extends JpaRepository<Book, String> {
	@Query("select book from Book as book where book.category.name=:name")
	List<Book> findByCategoryName(String name);

}
