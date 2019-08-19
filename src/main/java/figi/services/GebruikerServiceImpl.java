package figi.services;

import figi.pojo.Gebruiker;
import figi.pojo.GebruikerDto;
import figi.security.GebruikerDetailsService;
import figi.security.GebruikerPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import figi.repositories.GebruikerRepository;;import javax.persistence.EntityExistsException;

@Service
public class GebruikerServiceImpl implements GebruikerService{
	@Autowired
    private GebruikerRepository gebruikerRepository;
	@Autowired
    private PasswordEncoder wwEncoder = new BCryptPasswordEncoder();

    @Override
    @Transactional(readOnly = true)
    public UserDetails laadGebruikerMetEmail(String email) {
    	return null;
    }

    @Override
    public Gebruiker opslaan(GebruikerDto gebruikerDto) throws IllegalArgumentException {
        Gebruiker gebruiker = new Gebruiker();
        gebruiker.setVoornaam(gebruikerDto.getVoornaam());
        gebruiker.setAchternaam(gebruikerDto.getAchternaam());
        gebruiker.setEmail(gebruikerDto.getEmail());
        gebruiker.setWachtwoord(wwEncoder.encode(gebruikerDto.getWachtwoord()));
        gebruiker.setRol("GEBRUIKER");
        gebruikerRepository.save(gebruiker);
        return gebruiker;
    }

    @Override
    public Gebruiker ingelogdeGebruiker(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Gebruiker gebruiker = gebruikerRepository.findByEmail(authentication.getName());
        return gebruiker;
    }

    @Override
    public boolean verwijder() {
        gebruikerRepository.deleteById(ingelogdeGebruiker().getId());
        return true;
    }
}
