package org.java.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Inf implements Serializable {

    private Integer id;
    private String name;
    private Integer age;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
