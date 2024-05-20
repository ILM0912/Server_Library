package marlena.repository;

import marlena.domain.Book;
import marlena.domain.People;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PeopleRepository extends JpaRepository<People, Integer> {

    List<People> getByPassport(String passport);
    List<People> getByPhone(String phone);
}