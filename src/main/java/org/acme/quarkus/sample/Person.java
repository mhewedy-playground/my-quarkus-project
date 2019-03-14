package org.acme.quarkus.sample;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class Person extends PanacheEntity {
    public String name;

    public static List<Person> searchByName(String name) {
        return list("upper(name)", "%" + name.toUpperCase() + "%");
    }
}
