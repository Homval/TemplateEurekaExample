package com.example.clientservice.controllers;

import com.example.clientservice.feignclients.BookServiceFeignClient;
import com.example.clientservice.model.Book;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Value("${eureka.instance.instance-id}")
    String value;

    private final BookServiceFeignClient bookServiceFeignClient;

    public ClientController(BookServiceFeignClient bookServiceFeignClient) {
        this.bookServiceFeignClient = bookServiceFeignClient;
    }

    @GetMapping("/books")
    public List<Book> getAllBooksFromClient() {
        return bookServiceFeignClient.getBooks();
    }

    @GetMapping("/test")
    public String test() {
        return value;
    }

}
