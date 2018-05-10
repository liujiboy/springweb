package app;



import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import app.service.BookService;
import app.service.CategoryService;

@SpringBootApplication
@EnableTransactionManagement
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    @Bean
	public CommandLineRunner demo(CategoryService categoryService,BookService bookService) {
    		return (args)->{
    			categoryService.initCategories();
    			bookService.initBooks();
    		};
    }
}