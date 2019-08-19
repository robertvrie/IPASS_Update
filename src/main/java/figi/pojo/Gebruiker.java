package figi.pojo;

import java.util.Collection;
import java.util.Set;

import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Gebruiker {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String voornaam;

	@Column(nullable = false)
	private String achternaam;

	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private String wachtwoord;

	private String rol;


	public Gebruiker(String voornaam, String achternaam, String email, String wachtwoord, String rol){
		this.voornaam = voornaam;
		this.achternaam = achternaam;
		this.email = email;
		this.wachtwoord = wachtwoord;
		this.rol = rol;
	}

	public Gebruiker(){}

	public Long getId() { return id; }
	public String getVoornaam() {
		return voornaam;
	}
	public String getAchternaam() {
		return achternaam;
	}
	public String getEmail() { return email; }
	public String getRol() {
		return rol;
	}
	public String getWachtwoord() {
		return wachtwoord;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}

	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setWachtwoord(String wachtwoord) {
		this.wachtwoord = wachtwoord;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
}
