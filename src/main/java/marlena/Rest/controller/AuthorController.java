package marlena.Rest.controller;

import lombok.RequiredArgsConstructor;
import marlena.Rest.dataTransferObject.AuthorDto;
import marlena.domain.Author;
import marlena.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping("/author")
    public List<AuthorDto> getAllAuthor() {
        return authorService
                .getAll()
                .stream()
                .map(AuthorDto::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/author")
    public AuthorDto insertAuthor(@RequestBody AuthorDto authorDto) {
        Author author = authorService.insert(AuthorDto.toDomainObject(authorDto));
        return AuthorDto.toDto(author);
    }
    @GetMapping("/author/{id}")
    public AuthorDto getAuthor(@PathVariable int id) {
        Author author = authorService.getById(id);
        return AuthorDto.toDto(author);
    }
}