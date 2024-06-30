package com.ftn.modul3.zavrsni.jwd.Utakmice.service;

import java.util.List;

import com.ftn.modul3.zavrsni.jwd.Utakmice.model.Igrac;
import com.ftn.modul3.zavrsni.jwd.Utakmice.model.Reprezentacija;

public interface ReprezentacijaService {
	
	
	 Reprezentacija findOne(Long id);
	 List<Reprezentacija> findAll();
	 Reprezentacija update(Reprezentacija reprezentacija);

}
