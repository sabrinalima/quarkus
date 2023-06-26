package org.br.mineradora.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.br.mineradora.dto.PersonDTO;
import org.br.mineradora.entity.PersonEntity;
import org.br.mineradora.repository.PersonRepository;

@ApplicationScoped
public class PersonServiceImpl implements PersonService{

    @Inject
    PersonRepository personRepository;

    @Override
    public PersonDTO findPerson(long id) {

        PersonEntity person = personRepository.findById(id);
        return PersonDTO.builder()
                .personId(person.getId())
                .nome(person.getNome())
                .build();

    }

    @Override
    @Transactional
    public void createNewPerson(PersonDTO personDTO) {
        try{
            PersonEntity person = new PersonEntity();

            person.setNome(personDTO.getNome());

            personRepository.persist(person);

        } catch (Exception e) {
            e.printStackTrace();
            throw  new RuntimeException();
        }

    }

    @Override
    @Transactional
    public void updatePerson(PersonDTO personDTO, long id) {
        try{

            PersonEntity person = personRepository.findById(id);

            person.setNome(personDTO.getNome());

            personRepository.persist(person);

        } catch (Exception e) {
            e.printStackTrace();
            throw  new RuntimeException();
        }

    }

    @Override
    @Transactional
    public void removePerson(long id) {
        personRepository.deleteById(id);
    }

}
