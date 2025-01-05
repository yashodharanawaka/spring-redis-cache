package yhr.demo.redis_cache;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookService {

    private final RestTemplate restTemplate;

    @Cacheable(value = "books", key = "#isbn")
    public String fetchBooks(String isbn) {
        String url = UriComponentsBuilder.fromUriString("https://openlibrary.org/api/books")
                .queryParam("bibkeys", "ISBN:" + isbn)
                .queryParam("format", "json")
                .toUriString();
        return restTemplate.getForObject(url, String.class);
    }
}
