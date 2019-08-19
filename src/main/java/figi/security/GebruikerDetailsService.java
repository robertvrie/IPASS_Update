package figi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import figi.pojo.Gebruiker;
import figi.repositories.GebruikerRepository;

@Service
public class GebruikerDetailsService implements UserDetailsService{

	@Autowired
	private GebruikerRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Gebruiker gebruiker = this.repo.findByEmail(email);
		if(gebruiker==null) {
			throw new UsernameNotFoundException("Gebruiker 404");
		}
		GebruikerPrincipal gebruikerPrincipal = new GebruikerPrincipal(gebruiker);
		return gebruikerPrincipal;
	}

}
