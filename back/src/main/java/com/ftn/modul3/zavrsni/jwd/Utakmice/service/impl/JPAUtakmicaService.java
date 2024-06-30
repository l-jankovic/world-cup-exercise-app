package com.ftn.modul3.zavrsni.jwd.Utakmice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ftn.modul3.zavrsni.jwd.Utakmice.model.Reprezentacija;
import com.ftn.modul3.zavrsni.jwd.Utakmice.model.Utakmica;
import com.ftn.modul3.zavrsni.jwd.Utakmice.repository.ReprezentacijaRepo;
import com.ftn.modul3.zavrsni.jwd.Utakmice.repository.UtamicaRepo;
import com.ftn.modul3.zavrsni.jwd.Utakmice.service.UtakmicaService;

@Service
public class JPAUtakmicaService implements UtakmicaService{

	@Autowired
	private UtamicaRepo repo;
	
	@Autowired
	private ReprezentacijaRepo reprezentacijaRepo;
	
	@Override
	public Utakmica findOne(Long id) {
		return repo.findById(id).orElseGet(null);
	}

	@Override
	public List<Utakmica> findAll() {
		return repo.findAll();
	}

	@Override
	public Page<Utakmica> findAll(int pageNo) {
		return repo.findAll(PageRequest.of(pageNo, 2));
	}

	@Override
	public Page<Utakmica> search(Long reprezentacijaAId, Long reprezentacijaBId, int page) {
		
		if (reprezentacijaAId == null && reprezentacijaBId == null) {
		    return repo.search(reprezentacijaAId, reprezentacijaBId, PageRequest.of(page, 2));
	    }
	    
	    Reprezentacija rA = reprezentacijaAId != null ? reprezentacijaRepo.findById(reprezentacijaAId).orElse(null) : null;
	    Reprezentacija rB = reprezentacijaBId != null ? reprezentacijaRepo.findById(reprezentacijaBId).orElse(null) : null;
	    
	    if (rA != null && rB != null && rA.getId().equals(rB.getId())) {
	        throw new IllegalArgumentException("Ne mogu se pretrazivate iste reprezentacije");
	    }
	    
	    return repo.search(reprezentacijaAId, reprezentacijaBId, PageRequest.of(page, 2));
	
	}
	
	

	@Override
	public Utakmica save(Utakmica utakmica) {
		
		return repo.save(utakmica);
	}

	@Override
	public Utakmica update(Utakmica utakmica) {
		return repo.save(utakmica);
	}
	
	

	@Override
	public Utakmica delete(Long id) {
		Utakmica u = findOne(id);
		
		if(u !=null) {
			
			repo.delete(u);
			return u;
		}
		
		return null;
	
	}
	
	
	public Utakmica povecajGoA(Long id) {
		Utakmica u = findOne(id);
		int go = u.getBrojGolovaA();
		int dodatGo=++go;
		u.setBrojGolovaA(dodatGo);
		update(u);
		return u;
		
		
		
		
	}
	
	public Utakmica povecajGoB(Long id) {
		Utakmica u = findOne(id);
		int go = u.getBrojGolovaB();
		int dodatGo=++go;
		u.setBrojGolovaB(dodatGo);
		update(u);
		return u;
		
	}

}
