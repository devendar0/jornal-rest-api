package My_first_project.Entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class JornalEntry {
    @Id
    private String id;
    private String name;
    private String content;


}
