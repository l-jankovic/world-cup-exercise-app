package com.ftn.modul3.zavrsni.jwd.Utakmice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ftn.modul3.zavrsni.jwd.Utakmice.model.Utakmica;

@Repository
public interface UtamicaRepo  extends JpaRepository<Utakmica, Long>{
	
	@Query("SELECT u FROM Utakmica u WHERE "+
			"(:reprezentacijaAId IS NULL OR u.reprezentacijaA.id=:reprezentacijaAId) AND "+
			"(:reprezentacijaBId IS NULL OR u.reprezentacijaB.id=:reprezentacijaBId)")
	Page<Utakmica> search(@Param("reprezentacijaAId")Long reprezentacijaAId,@Param("reprezentacijaBId")Long reprezentacijaBId,Pageable pageable);

}
