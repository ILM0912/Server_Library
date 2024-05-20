package marlena.service;

import lombok.RequiredArgsConstructor;
import marlena.domain.Author;
import marlena.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService{
    private final AuthorRepository authorRepository;
    @Override
    public Author insert(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author getById(int id) {
        return authorRepository.findById(id).orElse(null);
    }
}
