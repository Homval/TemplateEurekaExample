package clientservice2.controllers;

import clientservice2.feignclients.BookServiceFeignClient;
import clientservice2.model.Book;
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

    @GetMapping("/books")
    public List<Book> getAllBooksFromClient() {
        return bookServiceFeignClient.getBooks();
    }

    @GetMapping("/test")
    public String test() {
        return "test2";
    }

}
