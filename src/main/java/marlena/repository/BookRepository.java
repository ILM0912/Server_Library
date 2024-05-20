package marlena.repository;

import marlena.domain.Book;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    @Override
    @EntityGraph(attributePaths = {"author", "people"})
    List<Book> findAll();

    @EntityGraph(attributePaths = {"author", "people"})
    List<Book> findByPeopleIdNot(int id);
}
