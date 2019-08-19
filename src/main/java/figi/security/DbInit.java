package figi.security;

import figi.pojo.Gebruiker;
import figi.repositories.GebruikerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DbInit implements CommandLineRunner {
    @Autowired
    private GebruikerRepository gebruikerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args){
        this.gebruikerRepository.deleteAll();

        Gebruiker robert = new Gebruiker("Robert-Jan","Vrieling", "robertvrie@gmail.com", passwordEncoder.encode("twink"), "GEBRUIKER");
        Gebruiker manager = new Gebruiker("Bob", "de Bouwer", "test@test.nl", passwordEncoder.encode("1234"), "MANAGEMENT");

        this.gebruikerRepository.save(robert);
        this.gebruikerRepository.save(manager);
    }
}
