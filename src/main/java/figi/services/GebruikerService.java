package figi.services;

import figi.pojo.Gebruiker;
import figi.pojo.GebruikerDto;
import org.springframework.security.core.userdetails.UserDetails;

public interface GebruikerService {
	UserDetails laadGebruikerMetEmail(String email);

    Gebruiker opslaan(GebruikerDto gebruikerDto) throws IllegalArgumentException;

    Gebruiker ingelogdeGebruiker();

    boolean verwijder();
}
