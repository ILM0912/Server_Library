package marlena;

import marlena.domain.Author;
import marlena.domain.Book;
import marlena.domain.People;
import marlena.repository.AuthorRepository;
import marlena.repository.BookRepository;
import marlena.repository.PeopleRepository;
import marlena.service.LibraryDemoService;
import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.sql.SQLException;
import java.util.List;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
    }
}
