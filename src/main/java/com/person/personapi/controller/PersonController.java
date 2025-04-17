package com.person.personapi.controller;

import com.person.personapi.model.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.person.personapi.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

  @Autowired
  private PersonService personService;

  @GetMapping
  public ResponseEntity<List<Person>> getAllPersons() {
    List<Person> persons = personService.getAllPersons();
    return ResponseEntity.ok(persons);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Person> getPerson(@PathVariable Integer id) {
    Person currentPerson = personService.getPerson(id);
    return currentPerson != null ? ResponseEntity.ok(currentPerson) : ResponseEntity.notFound().build();
  }

  @PostMapping()
  public ResponseEntity<Void> addPerson(@RequestBody Person currentPerson) {
    personService.addPerson(currentPerson);
    return ResponseEntity.noContent().build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<Void> updatePerson(@PathVariable Integer id, @RequestBody Person currentPerson) {
    if (!id.equals(currentPerson.getId())) {
      return ResponseEntity.badRequest().build();
    }
    personService.updatePerson(currentPerson);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletePerson(@PathVariable Integer id) {
    personService.deletePerson(id);
    return ResponseEntity.noContent().build();
  }
}
