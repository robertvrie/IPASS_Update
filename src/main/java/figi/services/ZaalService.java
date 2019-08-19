package figi.services;

import figi.pojo.Zaal;

import java.util.List;

public interface ZaalService {
    Zaal vindOpId(Long id);

    List<Zaal> vindAlle();

    void verwijder(Long id);

    Zaal opslaan(Zaal zaal);
}
