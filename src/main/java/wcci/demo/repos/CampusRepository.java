package wcci.demo.repos;

import org.springframework.data.repository.CrudRepository;
import wcci.demo.model.Campus;

public interface CampusRepository extends CrudRepository<Campus, Long> {
}
