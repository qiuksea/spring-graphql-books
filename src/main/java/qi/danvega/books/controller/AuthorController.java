package qi.danvega.books.controller;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import qi.danvega.books.model.Author;
import qi.danvega.books.model.Book;
import qi.danvega.books.repository.AuthorRepository;
import qi.danvega.books.repository.BookRepository;

import java.util.Optional;

@Controller
public class AuthorController {

    private final AuthorRepository authorRepository;

    private final BookRepository bookRepository;

    public AuthorController(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @QueryMapping
    public Iterable<Author> authors(){
        return authorRepository.findAll();
    }

    @QueryMapping
    Optional<Author> authorById(@Argument Integer id){
        return authorRepository.findById(id);
    }

    @MutationMapping
    Book addBook(@Argument BookInput book){
        Author author = authorRepository.findById(book.authorId).orElseThrow(() -> new IllegalArgumentException("author no found"));
        Book newBook = new Book(book.title, book.pages, author);
        return bookRepository.save(newBook);
    }

    record BookInput(String title, Integer pages, Integer authorId){}

    /*
    mutation{
     addBook(book: {title: "java 17", pages: 200, authorId: 1}){
     id
    }
     */
}
