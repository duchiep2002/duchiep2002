package edu.poly.sendemail.repository;

import edu.poly.sendemail.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByDepartmentAndGender(String Deparment, String Gender);
}
