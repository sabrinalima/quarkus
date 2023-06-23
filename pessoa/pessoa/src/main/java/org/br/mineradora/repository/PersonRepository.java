package org.br.mineradora.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.br.mineradora.entity.PersonEntity;

@ApplicationScoped
public class PersonRepository implements PanacheRepository<PersonEntity> {


}
