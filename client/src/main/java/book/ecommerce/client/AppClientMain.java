package book.ecommerce.client;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("book.ecommerce.library.model")
@EnableJpaRepositories("book.ecommerce.library.repository")
   public class AppClientMain {
    public static void main(String[] args) {
        SpringApplication.run(AppClientMain.class, args);
    }
}