package com.example.clientservice.feignclients;

import com.example.clientservice.config.FeignConfig;
import com.example.clientservice.model.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collections;
import java.util.List;

@Service
@FeignClient(name = "book-service", configuration = FeignConfig.class, fallback = BookServiceFeignClient.BookServiceFeignClientFallbackFactory.class)
public interface BookServiceFeignClient {

    @GetMapping("/api/books")
    List<Book> getBooks();

    @Component
    class BookServiceFeignClientFallbackFactory implements FallbackFactory<FallbackWithFactory> {
        @Override
        public FallbackWithFactory create(Throwable cause) {
            return new FallbackWithFactory(cause.getMessage());
        }
    }

    @Slf4j
    record FallbackWithFactory(String reason) implements BookServiceFeignClient {
        @Override
        public List<Book> getBooks() {
            log.info("Failed send request on book service, reason {}", reason);
            return Collections.emptyList();
        }
    }
}
