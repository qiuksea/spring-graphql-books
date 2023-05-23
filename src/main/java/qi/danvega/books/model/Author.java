package qi.danvega.books.model;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


//one author has many books
@Entity
@Table(name = "authors")
public class Author{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Transient
    public String fullName(){
        return firstName + " " + lastName;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "author_id")
    private List<Book> books;

    public Author() {
    }

    public Author(String firstName, String lastName) {
        //this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
/*
    public Author(Integer id, String firstName, String lastName) {
        this(id, firstName, lastName, List.of());
    }

*/

}


/*
public record Author(Integer id, String firstName, String lastName) {

    public String fullName(){
        return firstName + " " + lastName;
    }
}

 */