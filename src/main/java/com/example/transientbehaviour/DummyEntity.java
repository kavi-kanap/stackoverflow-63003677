package com.example.transientbehaviour;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class DummyEntity {
    @Id
    private Long id;

    private String name;

    @Transient
    private String transientField;

    public DummyEntity() {
        System.out.println();
    }

    public String getTransientField() {
        return transientField;
    }

    public void setTransientField(String transientField) {
        this.transientField = transientField;
    }

    public DummyEntity(Long id, String name, String transientField) {
        this.id = id;
        this.name = name;
        this.transientField = transientField;
    }

    public DummyEntity(String name, String transientField) {
        this.name = name;
        this.transientField = transientField;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
