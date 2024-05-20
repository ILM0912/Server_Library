package marlena.service;

import lombok.RequiredArgsConstructor;
import marlena.domain.Book;
import marlena.domain.People;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LibraryDemoService {
    private final AuthorService authorService;
    private final BookService bookService;
    private final PeopleService peopleService;

    @Transactional
    public void bookDemo() {
        List<Book> bookInUse = bookService.getBooksInUse();
        for (Book book : bookInUse) {
            System.out.println(book.getPeople().getId());
        }
        //peopleService.insert("Чел", "1234 567890", "+79876543219");

        List<People> users1 = peopleService.getByPassport("1234 567890");
        for (People user : users1) {
            System.out.println(user.getId() + user.getName());
        }

        List<People> users2 = peopleService.getByPhone("+79876543219");
        for (People user : users2) {
            System.out.println(user.getId() + user.getName());
        }
        //bookService.update(10005, 10020, "09-05-2005");
        //bookService.update(10003, 0, "not");
        List<People> badUsers = bookService.getUsers();
        for (People badUser : badUsers) {
            System.out.println(badUser.getId() + badUser.getName());
        }
    }
}
