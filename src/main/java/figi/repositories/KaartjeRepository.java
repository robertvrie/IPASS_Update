package figi.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import figi.pojo.Kaartje;

import java.util.ArrayList;

@Repository
public interface KaartjeRepository extends CrudRepository<Kaartje, Long>{
}
