package com.example.clientservice.feignclients;

import com.example.clientservice.config.FeignConfig;
import com.example.clientservice.model.Book;
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
