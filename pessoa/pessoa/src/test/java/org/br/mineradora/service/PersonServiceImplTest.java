package org.br.mineradora.service;

import io.quarkus.panache.mock.PanacheMock;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import io.quarkus.test.junit.mockito.InjectSpy;
import jakarta.inject.Inject;
import org.br.mineradora.dto.PersonDTO;
import org.br.mineradora.entity.PersonEntity;
import org.br.mineradora.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;

import java.util.Optional;

import static io.quarkus.hibernate.orm.panache.PanacheEntity_.id;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.testcontainers.shaded.org.hamcrest.MatcherAssert.assertThat;

@QuarkusTest
class PersonServiceImplTest {

    @Mock
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
    void createNewPerson()  {
//        PersonEntity person = new PersonEntity();
//        person.setNome("Bernardo");
//        PersonDTO dto = PersonDTO.builder()
//                .personId(person.getId())
//                .nome(person.getNome())
//                .build();
//
//        personRepository.persist(person);
//        //doThrow(Exception.class).when(personService).createNewPerson(dto);
//
//
//      //  personService.createNewPerson(dto);

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