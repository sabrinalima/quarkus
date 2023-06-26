package org.br.mineradora.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.br.mineradora.dto.PersonDTO;

@ApplicationScoped
public interface PersonService {

    PersonDTO findPerson(long id);

    void createNewPerson(PersonDTO personDTO);

    void updatePerson(PersonDTO personDTO, long id);

    void removePerson(long id);

}
