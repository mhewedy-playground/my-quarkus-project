package org.acme.quarkus.sample;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class PersonService {

    @Transactional
    public void persist(String name) {
        Person person = new Person();
        person.name = name;
        person.persist();
    }

    @Transactional
    public List<Person> searchByName(String name) {
        return Person.searchByName(name);
    }
}
