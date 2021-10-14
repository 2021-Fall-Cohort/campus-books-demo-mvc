package wcci.demo.repos;

import org.springframework.data.repository.CrudRepository;
import wcci.demo.model.Author;

import java.util.Optional;

public interface AuthorRepository extends CrudRepository<Author, Long> {
    Optional<Author> findByName(String name);
}
