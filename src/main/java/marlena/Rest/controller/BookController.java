package marlena.Rest.controller;

import lombok.RequiredArgsConstructor;
import marlena.Rest.dataTransferObject.BookDto;
import marlena.domain.Book;
import marlena.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/book")
    public List <Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/book/{id}")
    public BookDto getById(@PathVariable int id) {
        return BookDto.toDto(bookService.getById(id));
    }

    @GetMapping("/book/use")
    public List <Book> getById() {
        return bookService.getBooksInUse();
    }

    @PutMapping("/book/{id}")
    public BookDto updateBook(@PathVariable int id, @RequestParam String person,@RequestParam String date){
        Book book = bookService.update(id, Integer.parseInt(person), date);
        return BookDto.toDto(book);
    }
}
