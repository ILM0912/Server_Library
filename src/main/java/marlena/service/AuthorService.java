package marlena.service;

import marlena.domain.Author;

import java.util.List;

public interface AuthorService {
    Author insert(Author author);
    List<Author> getAll();
    Author getById(int id);
}
