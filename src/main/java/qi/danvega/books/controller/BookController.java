package qi.danvega.books.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import qi.danvega.books.model.Book;
import qi.danvega.books.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Controller
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @SchemaMapping(typeName = "Query", value = "allBooks")
    public List<Book> findAll(){
        return bookRepository.findAll();
    }


    @QueryMapping
    Optional<Book> findOne(@Argument Integer id) {
        return bookRepository.findById(id);
    }


}

//this is a test for git develop branch
//test again
