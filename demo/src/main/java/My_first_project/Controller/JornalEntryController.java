package My_first_project.Controller;

import My_first_project.Entity.JornalEntry;
import My_first_project.Service.Service;
import org.springframework.beans.factory.annotation.Autowired; // Naya import
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/get-post-url")
public class JornalEntryController {

    @Autowired
    private Service obj;

    @GetMapping
    public ResponseEntity<?> GetAll() {
        List<JornalEntry> allEntries = obj.getAll();
        if (allEntries.isEmpty()) {
            return new ResponseEntity<>("No data found in Cloud DB", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(allEntries, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createEntry(@RequestBody JornalEntry myEntry) {
        obj.Post(myEntry);
        return new ResponseEntity<>("Bhai MongoDB Cloud may save hogya data!", HttpStatus.CREATED);
    }

    @GetMapping("/id/{myid}")
    public ResponseEntity<?> GetbyId(@PathVariable String myid) {
          Optional<JornalEntry> entry =obj.GETBYID(myid);
        if (entry.isPresent()) {
            return new ResponseEntity<>(entry.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Id not found in DB", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/id/{myid}")
    public ResponseEntity<String> delete(@PathVariable String myid) {
      boolean bool=obj.DeleteBYID(myid);
        if (bool) {
            return new ResponseEntity<>("Deleted successfully from DB!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Id not found to delete", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update/{Myid}")
    public ResponseEntity<String> update(@PathVariable String Myid, @RequestBody JornalEntry entry) {
       boolean bool=obj.UpdatebyId(Myid,entry);
        if (bool) {
            return new ResponseEntity<>("Update Done in DB!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Id not found to update", HttpStatus.NOT_FOUND);
    }
    @GetMapping("/name/{Name}")
    public ResponseEntity<?> GetByName(@PathVariable String Name) {
        java.util.List<JornalEntry>data =obj.GetBYName(Name);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}