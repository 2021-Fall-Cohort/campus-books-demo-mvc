package wcci.demo.repos;

import org.springframework.data.repository.CrudRepository;
import wcci.demo.model.Book;

public interface BookRepository extends CrudRepository<Book,Long> {
}
