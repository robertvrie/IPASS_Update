package figi.services;

import figi.pojo.FilmInfo;
import figi.repositories.FilmInfoRepository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmInfoServiceImpl implements FilmInfoService{
	@Autowired
	private FilmInfoRepository filmInfoRepository;
	
	@Override
	public List<FilmInfo> vindAlle(){
		List<FilmInfo> films = new ArrayList<>();
		filmInfoRepository.findAll().forEach(films::add);
		return films;
	}
	
	@Override
	public FilmInfo vindMetId(Long id) {
		return filmInfoRepository.findById(id).orElse(null);
	}
	
	@Override
	public FilmInfo opslaan(FilmInfo film) {
		filmInfoRepository.save(film);
		return film;
	}
	
	@Override
	public void verwijder(Long id) {
		filmInfoRepository.deleteById(id);
	}

}
