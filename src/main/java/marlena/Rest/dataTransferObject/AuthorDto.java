package marlena.Rest.dataTransferObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import marlena.domain.Author;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthorDto {
    private int id;
    private String name;

    public static AuthorDto toDto(Author author) {
        return new AuthorDto(
                author.getId(),
                author.getName()
        );
    }

    public static Author toDomainObject(AuthorDto author){
        return new Author(
                author.getId(),
                author.getName()
        );
    }
}
