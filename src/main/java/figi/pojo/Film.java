package figi.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

@Entity
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime datum;

    private Long filmInfo;

    private Long zaal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDatum() {
        return datum;
    }

    public void setDatum(LocalDateTime datum) {
        this.datum = datum;
    }

    public Long getFilmInfo() {
        return filmInfo;
    }

    public void setFilmInfo(Long filmInfo) {
        this.filmInfo = filmInfo;
    }

    public Long getZaal() {
        return zaal;
    }

    public void setZaal(Long zaal) {
        this.zaal = zaal;
    }
    }
