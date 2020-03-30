package hello;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class Application {

    @Bean
    MessageService mockMessageService() {
        return new MessageService() {
            public String getMessage() {
              return "mockMessageService:Hello World!";
            }
        };
    }
    @Bean
    String buffer() {
    		return "Appliccation:buffer";
    }


}