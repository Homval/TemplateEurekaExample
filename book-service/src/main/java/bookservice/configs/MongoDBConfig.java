package bookservice.configs;

import bookservice.model.Book;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.Arrays;
import java.util.List;

@Configuration
public class MongoDBConfig {
    private final MongoTemplate mongoTemplate;

    public MongoDBConfig(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            List<Book> books = Arrays.asList(
                    Book.builder().title("Book 1").description("Description 1").imageLink("Link 1").build(),
                    Book.builder().title("Book 2").description("Description 2").imageLink("Link 2").build(),
                    Book.builder().title("Book 3").description("Description 3").imageLink("Link 3").build()
            );

            mongoTemplate.insertAll(books);
        };
    }

}
