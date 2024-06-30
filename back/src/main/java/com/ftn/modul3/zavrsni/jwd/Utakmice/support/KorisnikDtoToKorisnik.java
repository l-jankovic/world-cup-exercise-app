package com.ftn.modul3.zavrsni.jwd.Utakmice.support;


import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftn.modul3.zavrsni.jwd.Utakmice.model.Korisnik;
import com.ftn.modul3.zavrsni.jwd.Utakmice.service.KorisnikService;
import com.ftn.modul3.zavrsni.jwd.Utakmice.web.dto.KorisnikDTO;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Component
public class KorisnikDtoToKorisnik implements Converter<KorisnikDTO, Korisnik> {

    @Autowired
    private KorisnikService korisnikService;



    @Override
    public Korisnik convert(KorisnikDTO korisnikDTO) {
        Korisnik entity = null;

        if(korisnikDTO.getId() == null) {
            entity = new Korisnik();
        }else {
            Optional<Korisnik> korisnikOptional = korisnikService.findOne(korisnikDTO.getId());
            if(korisnikOptional.isPresent()){
                entity = korisnikOptional.get();
            }
        }

        if(entity != null) {
            entity.setKorisnickoIme(korisnikDTO.getKorisnickoIme());
            entity.setEMail(korisnikDTO.geteMail());
            entity.setIme(korisnikDTO.getIme());
            entity.setPrezime(korisnikDTO.getPrezime());
        }

        return entity;
    }

}
