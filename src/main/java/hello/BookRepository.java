package hello;
import org.springframework.data.jpa.repository.JpaRepository;
//https://docs.spring.io/spring-data/data-jpa/docs/current/reference/html/
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends JpaRepository<Book, String> {

}
