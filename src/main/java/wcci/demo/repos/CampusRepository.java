package wcci.demo.repos;

import org.springframework.data.repository.CrudRepository;
import wcci.demo.model.Campus;

import java.util.Collection;

public interface CampusRepository extends CrudRepository<Campus, Long> {
    Campus findByLocationIgnoreCase(String location);
    Collection<Campus> findByTechStackIgnoreCase(String techStack);
}
