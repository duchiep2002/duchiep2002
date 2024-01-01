package edu.poly.sendemail.repository;

import edu.poly.sendemail.entity.Person;

import java.util.List;

public interface JpaDao {

    List<Person> getAllPeople();

    Person getPersonById(Long id);

    Person createPerson(Person person);

    Person updatePerson(Long id, Person updatePerson);

    void deletePerson(Long id);
}
