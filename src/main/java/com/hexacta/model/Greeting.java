package com.hexacta.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Greeting {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    @Id
    private Integer id;

    @Column
    private String value;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Greeting() {}

    public Greeting(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Greeting greeting = (Greeting) o;
        return Objects.equals(value, greeting.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
