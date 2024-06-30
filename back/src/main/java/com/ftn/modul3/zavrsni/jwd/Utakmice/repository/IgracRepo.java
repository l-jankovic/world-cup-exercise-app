package com.ftn.modul3.zavrsni.jwd.Utakmice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftn.modul3.zavrsni.jwd.Utakmice.model.Igrac;

@Repository
public interface IgracRepo extends JpaRepository<Igrac, Long> {
	
	 List<Igrac> findByReprezentacijaId(Long reprezentacijaId);

}
