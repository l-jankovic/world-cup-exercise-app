package com.ftn.modul3.zavrsni.jwd.Utakmice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftn.modul3.zavrsni.jwd.Utakmice.model.Reprezentacija;

@Repository
public interface ReprezentacijaRepo  extends JpaRepository<Reprezentacija, Long>{
	
	

}
