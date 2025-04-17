package com.person.personapi.service;

import org.springframework.stereotype.Service;

import com.person.personapi.model.Person;

import java.time.LocalDate;
import java.util.*;

@Service
public class PersonService {
  private final Map<Integer, Person> persons = new HashMap<>();

  public PersonService() {
    addPerson(new Person(1, "Sandeep", "Kalra", LocalDate.of(1990, 7, 25)));
    // addPerson(new Person(2, "Ansh", "Kalra", LocalDate.of(2022, 7, 8)));
  }

  public List<Person> getAllPersons() {
    return new ArrayList<>(persons.values());
  }

  public Person getPerson(int id) {
    return persons.get(id);
  }

  public boolean addPerson(Person currentPerson) {
    persons.put(currentPerson.getId(), currentPerson);
    return true;
  }

  public boolean deletePerson(int personid) {
    persons.remove(personid);
    return true;
  }

  public boolean updatePerson(Person currentPerson) {
    persons.put(currentPerson.getId(), currentPerson);
    return true;
  }
}
