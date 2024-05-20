package marlena.service;

import lombok.RequiredArgsConstructor;
import marlena.domain.Book;
import marlena.domain.People;
import marlena.repository.AuthorRepository;
import marlena.repository.BookRepository;
import marlena.repository.PeopleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{
    private final BookRepository bookRepository;
    private final PeopleRepository peopleRepository;
    @Override
    public List<Book> getBooksInUse() {
        return bookRepository.findByPeopleIdNot(0);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<People> getUsers() {
        List<Book> bookList = bookRepository.findByPeopleIdNot(0);
        List<People> users = new ArrayList<>();
        for (Book book : bookList) {
            users.add(book.getPeople());
        }
        return users;
    }

    @Override
    public Book getById(int id) {
        return bookRepository.getById(id);
    }

    @Override
    public Book update(int id, int person, String date) {
        Book book = bookRepository.getById(id);
        book.setPeople(peopleRepository.getById(person));
        book.setState(date);
        return bookRepository.save(book);
    }
}
