package edu.poly.sendemail.repository;

import edu.poly.sendemail.entity.Person;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class IdpersonDao implements JpaDao {

    @Override
    public List<Person> getAllPeople() {
        return null;
    }

    @Override
    public Person getPersonById(Long id) {
        return null;
    }

    @Override
    @Transactional
    public Person createPerson(Person person) {
        return null;
    }

    @Override
    @Transactional
    public Person updatePerson(Long id, Person updatePerson) {
        return null;
    }

    @Override
    @Transactional
    public void deletePerson(Long id){
    }
}
