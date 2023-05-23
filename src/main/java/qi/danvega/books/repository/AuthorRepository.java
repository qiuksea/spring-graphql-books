package qi.danvega.books.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qi.danvega.books.model.Author;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
    Author findByfirstName(String firstName);



    /*
    List<Author> findAll();

    Optional<Author> findById(Integer id);
    */

}



/*
@Repository
public class AuthorRepository {

    private List<Author> authors = new ArrayList<>();

    public List<Author> findAll() {

        return authors;
    }

    public Author findById(int id) {
        return authors.stream()
                .filter(author -> author.id() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Author not found"));
    }

    public Author findByName(String name) {
        return authors.stream()
                .filter(author -> author.fullName().equals(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Author not found"));
    }

    @PostConstruct
    private void init() {
        authors.add(new Author(1,"Josh","Long"));
        authors.add(new Author(2,"Mark","Heckler"));
        authors.add(new Author(3,"Greg","Turnquist"));
    }
}
*/