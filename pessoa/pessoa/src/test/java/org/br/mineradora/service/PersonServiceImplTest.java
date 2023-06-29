package org.br.mineradora.service;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import io.quarkus.test.junit.mockito.InjectSpy;
import org.br.mineradora.dto.PersonDTO;
import org.br.mineradora.entity.PersonEntity;
import org.br.mineradora.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.testcontainers.shaded.org.hamcrest.Matcher;

import static com.google.common.base.Predicates.equalTo;
import static org.mockito.Mockito.*;
import static org.testcontainers.shaded.org.hamcrest.MatcherAssert.assertThat;
import static org.testcontainers.shaded.org.hamcrest.Matchers.hasProperty;

@QuarkusTest
class PersonServiceImplTest {

    @InjectSpy
    private PersonService personService;

    @InjectMock
    PersonRepository personRepository;

    @Test
    void findPerson() {

//        PersonEntity person = new PersonEntity();
//        person.setId(2L);
//        person.setNome("Bernardo");
//        PersonDTO dto = PersonDTO.builder()
//                .personId(person.getId())
//                .nome(person.getNome())
//                .build();
//
//        when(personRepository.findById(person.getId())).thenReturn(person);
//        assertEquals(true, personService.findPerson(person.getId()).equals(dto));

    }

    @Test
    //Teste precisa de ajustes para ser finalizado
    void createNewPerson() throws Exception {
//        PersonEntity person = new PersonEntity();
//        person.setName("Bernardo");
//        PersonDTO dto = PersonDTO.builder()
//                .personId(person.getId())
//                .nome(person.getName())
//                .build();

//        personRepository.persist(person);
//        doThrow(Exception.class).when(personService).createNewPerson(dto);

//
//      //  personService.createNewPerson(dto);


//        personRepository.persist(any(PersonEntity.class));
//        PersonEntity returnedPerson = personService.createNewPerson(dto);
//        assertThat(returnedPerson, hasProperty("name", (Matcher<?>) equalTo("Bernardo")));

    }

    @Test
    void updatePerson() {
    }

    @Test
    //não está deletando no banco de dados
    void removePerson() {
//
//        PersonEntity person = new PersonEntity();
//        person.setId(5L);
//
//        when(personRepository.deleteById(person.getId())).thenReturn(true);
//        personService.removePerson(person.getId());

    }
}