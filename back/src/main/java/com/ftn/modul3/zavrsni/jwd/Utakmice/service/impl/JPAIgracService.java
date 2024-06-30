package com.ftn.modul3.zavrsni.jwd.Utakmice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.modul3.zavrsni.jwd.Utakmice.model.Igrac;
import com.ftn.modul3.zavrsni.jwd.Utakmice.repository.IgracRepo;
import com.ftn.modul3.zavrsni.jwd.Utakmice.service.IgracService;


@Service
public class JPAIgracService implements IgracService {
	
	
	@Autowired
	private IgracRepo igracRepo;
	@Override
	public Igrac findOne(Long id) {
		return igracRepo.findById(id).orElseGet(null);
	}

	@Override
	public List<Igrac> findAll() {
		return igracRepo.findAll();
	}

	@Override
	public Igrac update(Igrac igrac) {
		return igracRepo.save(igrac);
	}

	@Override
	public Igrac uvecajGolove(Long id) {
		Igrac i = findOne(id);
		
		int ukupnoGolova= i.getUkupnoGolova();
		int uvecaniGolovi= ++ukupnoGolova;
		
		i.setUkupnoGolova(uvecaniGolovi);
		update(i);
		
		return i;
	}

	@Override
	public List<Igrac> getByReprezentacijaId(Long reprezentacijaId) {
		return igracRepo.findByReprezentacijaId(reprezentacijaId);
	}

}
