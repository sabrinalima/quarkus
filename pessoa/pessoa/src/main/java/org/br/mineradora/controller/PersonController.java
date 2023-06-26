package org.br.mineradora.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.br.mineradora.dto.PersonDTO;
import org.br.mineradora.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/api/person")
public class PersonController {

    @Inject
    PersonService personService;

    private final Logger LOG = LoggerFactory.getLogger(PersonController.class);

    @GET
    @Path("/{id}")
    public PersonDTO findPerson(@PathParam("id") long id){
        return personService.findPerson(id);
    }

    @POST
    public Response createPerson (PersonDTO person){

        try{
            personService.createNewPerson(person);
            return Response.ok().build();

        } catch (Exception e){
            return Response.serverError().build();
        }

    }

    @PUT
    @Path("/{id}")
    public Response updatePerson (PersonDTO person, @PathParam("id") long id){

        try{
            personService.updatePerson(person,id);
            return Response.ok().build();

        } catch (Exception e){
            return Response.serverError().build();
        }

    }

    @DELETE
    @Path("/{id}")
    public Response removePerson(@PathParam("id") long id){

        try{
            personService.removePerson(id);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.serverError().build();
        }

    }

}
