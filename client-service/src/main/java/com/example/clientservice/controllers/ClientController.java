package com.example.clientservice.controllers;

import com.example.clientservice.feignclients.BookServiceFeignClient;
import com.example.clientservice.model.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    private BookServiceFeignClient bookServiceFeignClient;

    public ClientController(BookServiceFeignClient bookServiceFeignClient) {
        this.bookServiceFeignClient = bookServiceFeignClient;
    }

    @GetMapping("/book")
    public List<Book> getAllBooksFromClient() {
        return bookServiceFeignClient.getBooks();
    }

}
