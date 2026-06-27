    package My_first_project.Service;


    import My_first_project.Controller.JornalEntryController;
    import My_first_project.Entity.JornalEntry;
    import My_first_project.Repository.JournalEntryRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;

    import java.util.List;
    import java.util.Optional;

    @org.springframework.stereotype.Service
    public class Service {
        @Autowired
        private JournalEntryRepository jornalEntryRepository;
        //to get all data
        public List<JornalEntry> getAll()
        {
            return jornalEntryRepository.findAll();
        }
         //post maping
        public void Post(JornalEntry myEntry){
            jornalEntryRepository.save(myEntry);
        }
    ///Get by id
        public Optional<JornalEntry>  GETBYID(String myid){
            return jornalEntryRepository.findById(myid);
        }

        //Deleted BY id
        public boolean DeleteBYID(String id){

           if(jornalEntryRepository.existsById(id)){
              jornalEntryRepository.deleteById(id);
              return true;
           }
           return false;
        }
        //Update by id
        public boolean UpdatebyId(String id,JornalEntry entry)
        {
            if(jornalEntryRepository.existsById(id)){
                entry.setId(id);
                jornalEntryRepository.save(entry);
                return true;
            }
            return false;
        }
         // Get by name
        public List<JornalEntry> GetBYName(String Name){
            return jornalEntryRepository.findByName(Name);
        }


    }
