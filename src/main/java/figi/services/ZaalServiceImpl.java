package figi.services;

import figi.pojo.Zaal;
import figi.repositories.ZaalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ZaalServiceImpl implements ZaalService{
    private ZaalRepository zaalRepository;

    @Autowired
    public ZaalServiceImpl(ZaalRepository zaalRepository) {
        this.zaalRepository = zaalRepository;
    }

    public Zaal vindOpId(Long id){
        Zaal zaal = zaalRepository.findById(id).orElse(null);

        return zaal;
    }

    @Override
    public List<Zaal> vindAlle(){
        List<Zaal> zalen = new ArrayList<>();
        zaalRepository.findAll().forEach(zalen::add);
        return zalen;
    }

    @Override
    public void verwijder(Long id){
        zaalRepository.deleteById(id);
    }

    @Override
    public Zaal opslaan(Zaal zaal) throws EntityExistsException {
        if(zaalRepository.existsById(zaal.getId()) == true){
            throw new EntityExistsException("Deze zaal bestaat al");
        }
        else {
            zaalRepository.save(zaal);
        }
        return zaal;
    }

}
