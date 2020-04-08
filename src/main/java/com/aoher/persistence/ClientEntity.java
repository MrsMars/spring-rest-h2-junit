package com.aoher.persistence;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Data
@Entity
@Table(name = "CLIENTS")
public class ClientEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long id;
    @NotNull
    @Column(
            name = "NAME"
    )
    private String name;
    @NotNull
    @Column(
            name = "LAST_NAME"
    )
    private String lastName;
    @NotNull
    @Column(
            name = "AGE"
    )
    private String age;
    @Column(
            name = "GENDER"
    )
    private String gender;

    public ClientEntity() {
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getAge() {
        return this.age;
    }

    public String getGender() {
        return this.gender;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public void setAge(final String age) {
        this.age = age;
    }

    public void setGender(final String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientEntity that = (ClientEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(age, that.age) &&
                Objects.equals(gender, that.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName, age, gender);
    }

    public String toString() {
        long var10000 = this.getId();
        return "ClientEntity(id=" + var10000 + ", name=" + this.getName() + ", lastName=" + this.getLastName() + ", age=" + this.getAge() + ", gender=" + this.getGender() + ")";
    }
}
