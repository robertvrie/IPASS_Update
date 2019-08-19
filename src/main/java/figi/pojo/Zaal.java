package figi.pojo;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Zaal {

    @Id
    private Long id;
    private int aantalRijen;
    private int aantalStoelenPerRij;

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public int getAantalRijen() { return aantalRijen; }
    public void setAantalRijen(int aantalRijen) { this.aantalRijen = aantalRijen; }
    public int getAantalStoelenPerRij() { return aantalStoelenPerRij; }
    public void setAantalStoelenPerRij(int aantalStoelenPerRij) { this.aantalStoelenPerRij = aantalStoelenPerRij; }
}