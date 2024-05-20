package marlena.Rest.dataTransferObject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import marlena.domain.Book;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDto {
    private int id;
    private String name;
    private String state;
    private AuthorDto authorDto;
    private PeopleDto peopleDto;

    public static BookDto toDto(Book book){
        return new BookDto(
                book.getId(),
                book.getName(),
                book.getState(),
                AuthorDto.toDto(book.getAuthor()),
                PeopleDto.toDto(book.getPeople())
        );
    }
}
