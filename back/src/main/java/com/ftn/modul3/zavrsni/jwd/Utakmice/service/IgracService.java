package com.ftn.modul3.zavrsni.jwd.Utakmice.service;

import java.util.List;

import com.ftn.modul3.zavrsni.jwd.Utakmice.model.Igrac;




public interface IgracService {
	
	
	 Igrac findOne(Long id);
	 List<Igrac> findAll();
	 Igrac update(Igrac igrac);
	 
	 Igrac uvecajGolove(Long id);	 
	 List<Igrac> getByReprezentacijaId(Long reprezentacijaId);

}
