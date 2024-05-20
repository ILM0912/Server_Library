package marlena.Rest.controller;

import lombok.RequiredArgsConstructor;
import marlena.Rest.dataTransferObject.AuthorDto;
import marlena.Rest.dataTransferObject.PeopleDto;
import marlena.domain.Author;
import marlena.domain.People;
import marlena.service.AuthorService;
import marlena.service.PeopleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

@RestController
@RequiredArgsConstructor
public class PeopleController {
    private final PeopleService peopleService;

    @GetMapping("/people")
    public List<PeopleDto> getAllPeople() {
        return peopleService
                .getAll()
                .stream()
                .map(PeopleDto::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/people")
    public PeopleDto insertPeople(@RequestParam String name, @RequestParam String phone, @RequestParam String passport) {
        People people = peopleService.insert(name, phone, passport);
        return PeopleDto.toDto(people);
    }
    @GetMapping("/people/{id}")
    public PeopleDto getPeople(@PathVariable int id) {
        People people = peopleService.getById(id);
        return PeopleDto.toDto(people);
    }
    @GetMapping("/people/phone/{phone}")
    public List<PeopleDto> getPeopleByPhone(@PathVariable String phone) {
        List <PeopleDto> people = peopleService.getByPhone(phone)
                .stream()
                .map(PeopleDto::toDto)
                .collect(Collectors.toList());
        return people;
    }
    @GetMapping("/people/passport/{passport}")
    public List<PeopleDto> getPeopleByPassport(@PathVariable String passport) {
        List <PeopleDto> people = peopleService.getByPassport(passport)
                .stream()
                .map(PeopleDto::toDto)
                .collect(Collectors.toList());
        return people;
    }
}