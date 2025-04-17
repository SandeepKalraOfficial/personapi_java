package com.person.personapi.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.person.personapi.model.Person;
import com.person.personapi.service.PersonService;

// package com.person.personapi.controller;

// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;@ExtendWith(MockitoExtension.class)

@ExtendWith(MockitoExtension.class)
public class PersonControllerTest {

  @InjectMocks
  private PersonController personController;

  @Mock
  private PersonService personService;

  @Test
  void testGetPerson() {
    int testId = 1;

    // mock the service
    Mockito.when(personService.getPerson(testId))
        .thenReturn(new Person(testId, "Sandeep", "Kalra", LocalDate.of(1990, 7, 25)));

    // call the controller method
    ResponseEntity<Person> response = personController.getPerson(testId);

    // assert the result
    assertEquals(HttpStatus.OK, response.getStatusCode());
    Person person = response.getBody();

    assertNotNull(person);
    assertEquals("Sandeep", person.getFname());
    assertEquals("Kalra", person.getLname());

  }
}

// import com.person.personapi.model.Person;
// import com.person.personapi.service.PersonService;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Import;
// import org.springframework.context.annotation.Primary;
// import org.springframework.http.MediaType;
// import java.time.LocalDate;
// import java.util.List;
// import static org.mockito.Mockito.*;
// import static
// org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
// import static
// org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// @WebMvcTest(PersonController.class)
// @Import(PersonControllerTest.TestConfig.class) // Use manual mock config
// public class PersonControllerTest {

// @Autowired
// private MockMvc mockMvc;

// @Autowired
// private PersonService personService;

// @Autowired
// private ObjectMapper objectMapper;

// @BeforeEach
// void setUp() {
// reset(personService); // Reset mock between tests
// objectMapper.registerModule(new JavaTimeModule()); // Support for LocalDate
// }

// @Test
// void testGetPersonById_found() throws Exception {
// Person mockPerson = new Person(1, "Sandeep", "Kalra", LocalDate.of(1990, 7,
// 25));
// when(personService.getPerson(1)).thenReturn(mockPerson);

// mockMvc.perform(get("/api/persons/1")
// .contentType(MediaType.APPLICATION_JSON)
// .accept(MediaType.APPLICATION_JSON))
// .andDo(result ->
// System.out.println(result.getResponse().getContentAsString()))
// .andExpect(status().isOk())
// .andExpect(content().json(objectMapper.writeValueAsString(mockPerson)));
// }

// // @Test
// // void testGetAllPersons() throws Exception {
// // List<Person> mockList = List.of(
// // new Person(1, "Sandeep", "Kalra", LocalDate.of(1990, 7, 25)));
// // when(personService.getAllPersons()).thenReturn(mockList);
// // mockMvc.perform(get("/api/persons")
// // .contentType(MediaType.APPLICATION_JSON)
// // .accept(MediaType.APPLICATION_JSON))
// // .andDo(result ->
// // System.out.println(result.getResponse().getContentAsString()))
// // .andExpect(status().isOk())
// // .andExpect(content().json(objectMapper.writeValueAsString(mockList)));
// // }

// // Manual mock config to replace deprecated @MockBean
// @Configuration
// static class TestConfig {
// @Bean
// @Primary
// public PersonService personService() {
// return mock(PersonService.class);
// }
// }
// }