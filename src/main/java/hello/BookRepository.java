package hello;
//https://docs.spring.io/spring-data/data-jpa/docs/1.0.0.M1/reference/html/
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, String> {

}
