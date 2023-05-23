package qi.danvega.books.model;


import jakarta.persistence.*;

import java.util.List;
import java.util.Optional;


//many books belong to one author
@Entity
@Table(name= "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String title;

    private Integer pages;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    public Book() {
    }

    public Book(Integer id, String title, Integer pages, Author author) {
        this.id = id;
        this.title = title;
        this.pages = pages;
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}

/*
@ManyToOne(fetch = FetchType.LAZY, optional = false)
                   @JoinColumn(name = "author_id", nullable = false)
                   Optional<Author> author
 */
