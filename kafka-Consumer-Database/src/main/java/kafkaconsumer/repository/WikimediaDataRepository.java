package kafkaconsumer.repository;

import org.springframework.data.repository.CrudRepository;
import kafkaconsumer.models.Wikimediadata;

public interface WikimediaDataRepository extends CrudRepository<Wikimediadata, Long> {
    // Additional custom query methods can be defined here if needed
}
