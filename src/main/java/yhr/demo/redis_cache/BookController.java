package yhr.demo.redis_cache;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/")
@RequiredArgsConstructor
public class BookController {

    private final BookService testService;

    @GetMapping("/books")
    public String getBooks(@RequestParam String isbn) {
        return testService.fetchBooks(isbn);
    }
}
