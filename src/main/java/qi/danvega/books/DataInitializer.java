package qi.danvega.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import qi.danvega.books.model.Author;
import qi.danvega.books.model.Book;
import qi.danvega.books.repository.AuthorRepository;
import qi.danvega.books.repository.BookRepository;

import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {

        Author author1 = new Author("Josh","Long");
        Author author2 = new Author("Mark","Heckler");
        Author author3 = new Author("Greg","Turnquist");

        authorRepository.saveAll(List.of(author1, author2, author3));

        Book book1 = new Book("Reactive Spring", 484, authorRepository.findByFirstName("Josh"));
        Book book2 = new Book("Spring Boot Up & Running", 328, authorRepository.findByFirstName("Mark"));
        Book book3 = new Book("Hacking with Spring Boot 2.3", 392, authorRepository.findByFirstName("Greg"));
        Book book4 = new Book("Hacking with Spring Boot 3", 500, authorRepository.findByFirstName("Greg"));
        Book book5 = new Book("Spring Boot 3 Up & Running", 400, authorRepository.findByFirstName("Mark"));
        bookRepository.saveAll(List.of(book1, book2, book3, book4, book5));


        //bookRepository.save(book1);

    }
}

/*
        Book book1 = new Book(1,"Reactive Spring", 484, authorRepository.findById(1));
        bookRepository.save(book1);

        Book book2 = new Book(2,"Spring Boot Up & Running", 328, authorRepository.findByName("Mark Heckler"));
        bookRepository.save(book2);

        Book book3 = new Book(3,"Hacking with Spring Boot 2.3", 392, authorRepository.findByName("Greg Turnquist"));
        bookRepository.save(book3);

        Book book4 = new Book(4,"Hacking with Spring Boot 3", 500, authorRepository.findByName("Greg Turnquist"));
        bookRepository.save(book3);

        Book book5 = new Book(5,"Spring Boot 3 Up & Running", 400, authorRepository.findByName("Mark Heckler"));
        bookRepository.save(book3);
 */
