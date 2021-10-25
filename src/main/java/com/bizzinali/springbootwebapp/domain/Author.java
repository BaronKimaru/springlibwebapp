package com.bizzinali.springbootwebapp.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

// make this POJO into JPA entities that can be persisted into the db via Hibernate via below decorator eg @Entity
@Entity
public class Author{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;

    //since one book can be penned by many authors and viceversa
    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>(); // always initialize to new Hashset otherwise youll face problems when creating instances

    // JPA requires a zero args constructor
    public Author() {
    }

    // no need to initialize `books` and `authors` for us
    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    // toString method to display the properties of the object when logging or in the console

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", books=" + books +
                '}';
    }

    // To enforce Equality between the id of the java object and the record in the database
    //  utilise the below equals and hashCode methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        return id != null ? id.equals(author.id) : author.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

}