package org.acme.quarkus.sample;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@QuarkusTest
public class PersonTest {

    @Test
    public void testFindByName() {
        //setup
        addPerson("Wael");
        addPerson("Mohammad");
        addPerson("Mohannad");

        // when
        List<Person> persons = Person.searchByName("oha");

        // then
        assertThat(persons, contains(
                hasProperty("name", is("Mohammad")),
                hasProperty("name", is("Mohannad"))
        ));
    }

    private void addPerson(String name) {
        Person person = new Person();
        person.name = name;
        person.persist();
    }

}