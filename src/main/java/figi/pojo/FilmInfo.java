package figi.pojo;

import javax.persistence.*;
import java.awt.print.Book;
import java.util.Set;

@Entity
public class FilmInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String naam;
	private String beschrijving;
	private Long lengte;
	
	public Long getId() {return id;}
	public void setId(Long id) {this.id = id;}
	public String getNaam() {return naam;}
	public void setNaam(String naam) {this.naam = naam;}
	public String getBeschrijving() {return beschrijving;}
	public void setBeschrijving(String beschrijving) {this.beschrijving = beschrijving;}
	public Long getLengte() {return lengte;}
	public void setLengte(Long lengte) {this.lengte = lengte;}
}