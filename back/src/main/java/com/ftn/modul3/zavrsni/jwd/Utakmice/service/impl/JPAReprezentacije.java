package com.ftn.modul3.zavrsni.jwd.Utakmice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.modul3.zavrsni.jwd.Utakmice.model.Igrac;
import com.ftn.modul3.zavrsni.jwd.Utakmice.model.Reprezentacija;
import com.ftn.modul3.zavrsni.jwd.Utakmice.repository.ReprezentacijaRepo;
import com.ftn.modul3.zavrsni.jwd.Utakmice.service.ReprezentacijaService;

@Service
public class JPAReprezentacije implements ReprezentacijaService {

	@Autowired
	private ReprezentacijaRepo repo;
	
	@Override
	public Reprezentacija findOne(Long id) {
		return repo.findById(id).orElseGet(null);
	}

	@Override
	public List<Reprezentacija> findAll() {
		return repo.findAll();
	}

	@Override
	public Reprezentacija update(Reprezentacija reprezentacija) {
			return repo.save(reprezentacija);
	}

}
