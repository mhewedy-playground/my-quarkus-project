package org.acme.quarkus.sample;

import io.quarkus.test.junit.QuarkusTest;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.List;


@QuarkusTest
public class PersonServiceTest {

    @Inject
    PersonService personService;

    @Test
    public void testPersist() {

        //setup
        personService.persist("Wael");
        personService.persist("Mohammad");
        personService.persist("Mohannad");
    }

    @Test
    public void testSearchByName() {

        //setup
        personService.persist("Wael");
        personService.persist("Mohammad");
        personService.persist("Mohannad");

        // when
        List<Person> persons = personService.searchByName("oha");

        // then
        MatcherAssert.assertThat(persons.size(), Matchers.greaterThanOrEqualTo(2));
    }
}