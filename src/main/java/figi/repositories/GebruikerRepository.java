package figi.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import figi.pojo.Gebruiker;

@Repository
public interface GebruikerRepository extends CrudRepository<Gebruiker, Long>{
	Gebruiker findByEmail(String email);
}
