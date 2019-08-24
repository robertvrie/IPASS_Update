package figi.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import figi.pojo.Kaartje;

import java.util.ArrayList;

@Repository
public interface KaartjeRepository extends CrudRepository<Kaartje, Long>{
    @Query(value = "SELECT * FROM KAARTJE WHERE GEBRUIKER = ?1", nativeQuery = true)
    ArrayList<Kaartje> findByGebruiker(Long gebruiker);
}
