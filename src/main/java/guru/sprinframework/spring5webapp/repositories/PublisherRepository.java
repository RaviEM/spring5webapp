package guru.sprinframework.spring5webapp.repositories;

import guru.sprinframework.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
