package org.acme.quarkus.sample;

import io.quarkus.test.junit.QuarkusTest;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import javax.transaction.Transactional;
import java.util.List;

@QuarkusTest
public class PersonTest {

    @Test
    @Transactional
    public void testFindByName() {
        //setup
        addPerson("Wael");
        addPerson("Mohammad");
        addPerson("Mohannad");

        // when
        List<Person> persons = Person.searchByName("oha");

        // then
        MatcherAssert.assertThat(persons, Matchers.hasSize(2));
    }

    private void addPerson(String name) {
        Person person = new Person();
        person.name = name;
        person.persist();
    }

}