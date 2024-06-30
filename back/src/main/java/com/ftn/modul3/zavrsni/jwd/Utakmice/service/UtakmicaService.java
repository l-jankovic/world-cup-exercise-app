package com.ftn.modul3.zavrsni.jwd.Utakmice.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ftn.modul3.zavrsni.jwd.Utakmice.model.Utakmica;



public interface UtakmicaService {
	
	
    Utakmica findOne(Long id);

    List<Utakmica> findAll();
    
    Page<Utakmica> findAll(int pageNo);

    Page<Utakmica> search(Long reprezentacijaAId,Long  reprezentacijaBId, int page);

    Utakmica save(Utakmica utakmica);

    Utakmica update(Utakmica utakmica);

    Utakmica delete(Long id);
    
    Utakmica povecajGoB(Long id);
    
    
    Utakmica povecajGoA(Long id);
	

}
