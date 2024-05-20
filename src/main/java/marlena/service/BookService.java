package marlena.service;

import marlena.domain.Book;
import marlena.domain.People;

import java.util.List;

public interface BookService {
    List<Book> getBooksInUse();
    List<Book> getAllBooks();
    List<People> getUsers();
    Book getById(int id);
    Book update(int id, int person, String date);
}
