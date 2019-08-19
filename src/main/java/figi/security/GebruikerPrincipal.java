package figi.security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import figi.pojo.Gebruiker;

public class GebruikerPrincipal implements UserDetails {

	
	private Gebruiker gebruiker;
	
	public GebruikerPrincipal(Gebruiker gebruiker) {
		super();
		this.gebruiker = gebruiker;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singleton(new SimpleGrantedAuthority("ROLE_" + this.gebruiker.getRol()));
	}
	
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.gebruiker.getWachtwoord();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.gebruiker.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
