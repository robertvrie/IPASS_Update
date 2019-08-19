package figi.services;

import java.util.List;

import figi.pojo.FilmInfo;

public interface FilmInfoService {

	List<FilmInfo> vindAlle();

	FilmInfo vindMetId(Long id);

	FilmInfo opslaan(FilmInfo film);

	void verwijder(Long id);

}
