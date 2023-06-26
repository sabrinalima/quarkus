package org.br.mineradora.controller;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectSpy;
import io.restassured.http.ContentType;
import org.br.mineradora.dto.PersonDTO;
import org.br.mineradora.entity.PersonEntity;
import org.br.mineradora.service.PersonService;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.mockito.Mockito.verify;

@QuarkusTest
@TestHTTPEndpoint(PersonController.class)
class PersonControllerTest {

    @InjectSpy
    PersonService service;

    @Test
    void createPerson() {

        PersonEntity person = new PersonEntity();
        person.setNome("Sabrina");
        PersonDTO dto = PersonDTO.builder()
                .personId(person.getId())
                .nome(person.getNome())
                .build();


        given()
                .contentType(ContentType.JSON)
                .body(dto)
                .when().post()
                .then().statusCode(200);

        verify(service).createNewPerson(dto);

    }

    @Test
    void findPerson() {

        PersonEntity person = new PersonEntity();
        person.setId(1L);
        person.setNome("Sabrina");
        PersonDTO dto = PersonDTO.builder()
                .personId(1L)
                .nome(person.getNome())
                .build();

        given().contentType(ContentType.JSON).param("id", dto.getPersonId())
                .when().get("/"+dto.getPersonId())
                .then().statusCode(200);

        verify(service).findPerson(dto.getPersonId());

    }

    @Test
    void updatePerson() {
    }

    @Test
    void removePerson() {
        PersonEntity person = new PersonEntity();
        person.setId(1L);
        PersonDTO dto = PersonDTO.builder()
                .personId(1L)
                .nome(person.getNome())
                .build();

        given().contentType(ContentType.JSON).param("id", dto.getPersonId())
                .when().delete("/"+dto.getPersonId())
                .then().statusCode(200);

        verify(service).removePerson(dto.getPersonId());
    }
}