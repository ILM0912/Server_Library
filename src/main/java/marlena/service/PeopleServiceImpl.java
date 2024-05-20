package marlena.service;

import lombok.RequiredArgsConstructor;
import marlena.domain.People;
import marlena.repository.PeopleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class PeopleServiceImpl implements PeopleService{
    private final PeopleRepository peopleRepository;
    @Override
    public People insert(String name, String phone, String passport) {
        People people = new People();
        people.setName(name);
        people.setPassport(passport); 
        people.setPhone(phone);
        return peopleRepository.save(people);
    }

    @Override
    public List<People> getAll() {
        return peopleRepository.findAll();
    }

    @Override
    public People getById(int id) {
        return peopleRepository.findById(id).orElse(null);
    }

    @Override
    public List<People> getByPassport(String passport) {
       return peopleRepository.getByPassport(passport);
    }

    @Override
    public List<People> getByPhone(String phone) {
        return peopleRepository.getByPhone(phone);
    }
}