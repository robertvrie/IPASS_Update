package figi.repositories;

import figi.pojo.Zaal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZaalRepository extends CrudRepository<Zaal, Long> {
}
