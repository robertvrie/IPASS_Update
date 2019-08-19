package figi.repositories;

import figi.pojo.FilmInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmInfoRepository extends CrudRepository<FilmInfo, Long>{
}
