package wcci.demo.repos;

import org.springframework.data.repository.CrudRepository;
import wcci.demo.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
