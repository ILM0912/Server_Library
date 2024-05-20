package marlena.service;

import marlena.domain.People;

import java.util.List;

public interface PeopleService {
    People insert(String name, String passport, String phone);
    List<People> getAll();
    People getById(int id);
    List <People> getByPassport(String passport);
    List <People> getByPhone(String phone);
}
