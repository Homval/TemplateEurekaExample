package clientservice2.feignclients;

import clientservice2.config.FeignConfig;
import clientservice2.model.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
@FeignClient(name = "book-service", configuration = FeignConfig.class)
public interface BookServiceFeignClient {
    @GetMapping("/api/books")
    List<Book> getBooks();
}
