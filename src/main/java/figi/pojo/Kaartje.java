package figi.pojo;

import jdk.internal.jline.internal.Nullable;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;

@Entity
public class Kaartje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long film;
    private int rij;
    private int stoel;
    private Long gebruiker;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFilm() {
        return film;
    }

    public void setFilm(Long film) {
        this.film = film;
    }

    public int getRij() {
        return rij;
    }

    public void setRij(int rij) {
        this.rij = rij;
    }

    public int getStoel() {
        return stoel;
    }

    public void setStoel(int stoel) {
        this.stoel = stoel;
    }

    public Long getGebruiker() {
        return gebruiker;
    }

    public void setGebruiker(Long gebruiker) {
        this.gebruiker = gebruiker;
    }
}
