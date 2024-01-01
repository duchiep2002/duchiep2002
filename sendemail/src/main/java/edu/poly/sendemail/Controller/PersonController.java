package edu.poly.sendemail.Controller;

import edu.poly.sendemail.entity.Person;
import edu.poly.sendemail.repository.SendmallJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("persons")
public class PersonController {
    @Autowired
    private SendmallJpa sendmallJpa;

    @GetMapping
    public ResponseEntity<List<Person>> getAllPersons(){
        List<Person> persons = sendmallJpa.findAll();
        return ResponseEntity.ok(persons);
    }

    @GetMapping("{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable("id") Long id) {
        Person person = sendmallJpa.find(id);
        if (person == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(person);
    }

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        Person savedPerson = sendmallJpa.save(person);
        return ResponseEntity.ok(savedPerson);
    }

    @PutMapping("{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable("id") Long id,@RequestBody Person person) {
        Person currentPerson = sendmallJpa.find(id);
        if (currentPerson == null) {
            return ResponseEntity.notFound().build();
        }
        currentPerson.setName(person.getName());
        currentPerson.setAge(person.getAge());
        currentPerson.setEmail(person.getEmail());
        currentPerson.setHometown(person.getHometown());
        currentPerson.setWorkunit(person.getWorkunit());
        Person updatePerson = sendmallJpa.update(currentPerson);
        return ResponseEntity.ok(updatePerson);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Person> deletePerson(@PathVariable("id") Long id) {
        Person person = sendmallJpa.find(id);
        if (person == null) {
            return ResponseEntity.noContent().build();
        }
        sendmallJpa.delete(id);
        return ResponseEntity.noContent().build();
    }

}
