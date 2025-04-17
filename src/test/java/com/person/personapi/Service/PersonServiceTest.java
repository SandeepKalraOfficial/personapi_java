package com.person.personapi.Service;

import com.person.personapi.service.PersonService;
import com.person.personapi.model.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonServiceTest {

  private PersonService personService;

  @BeforeEach
  void setUp() {
    personService = new PersonService();
  }

  @Test
  void test_getPerson() {
    Person currentPerson = personService.getPerson(1);
    assertNotNull(currentPerson);
    assertEquals(currentPerson.getFname(), "Sandeep");
  }

}
