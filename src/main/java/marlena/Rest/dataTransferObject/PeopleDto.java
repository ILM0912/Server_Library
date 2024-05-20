package marlena.Rest.dataTransferObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import marlena.domain.Author;
import marlena.domain.People;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PeopleDto {
    private int id;
    private String name;
    private String phone;
    private String passport;

    public static PeopleDto toDto(People people) {
        return new PeopleDto(
                people.getId(),
                people.getName(),
                people.getPhone(),
                people.getPassport()
        );
    }

    public static People toDomainObject(PeopleDto people){
        return new People(
                people.getId(),
                people.getName(),
                people.getPhone(),
                people.getPassport()
        );
    }
}
