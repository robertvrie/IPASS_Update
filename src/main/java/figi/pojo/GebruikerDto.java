package figi.pojo;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class GebruikerDto {
    @NotNull
    @NotEmpty
    private String voornaam;

    @NotNull
    @NotEmpty
    private String achternaam;

    @NotNull
    @NotEmpty
    private String email;

    @NotNull
    @NotEmpty
    private String wachtwoord;

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }
}
