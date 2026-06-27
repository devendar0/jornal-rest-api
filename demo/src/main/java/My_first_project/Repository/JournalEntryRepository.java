package My_first_project.Repository;

import My_first_project.Entity.JornalEntry;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface JournalEntryRepository extends MongoRepository<JornalEntry, String> {

    public List<JornalEntry> findByName(String Name);

}
