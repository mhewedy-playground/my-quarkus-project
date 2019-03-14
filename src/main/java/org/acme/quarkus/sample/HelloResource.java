package org.acme.quarkus.sample;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/person")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HelloResource {

    @Inject
    PersonService personService;

    @POST
    public void persist(String name) {
        personService.persist(name);
    }

    @GET
    @Path("/search")
    public List<Person> search(@QueryParam("name") String name) {
        return personService.searchByName(name);
    }
}