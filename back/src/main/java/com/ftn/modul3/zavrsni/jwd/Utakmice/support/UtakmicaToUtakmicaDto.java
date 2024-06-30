package com.ftn.modul3.zavrsni.jwd.Utakmice.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftn.modul3.zavrsni.jwd.Utakmice.model.Utakmica;
import com.ftn.modul3.zavrsni.jwd.Utakmice.web.dto.UtakmicaDTO;

@Component
public class UtakmicaToUtakmicaDto implements Converter<Utakmica, UtakmicaDTO> {

	@Override
	public UtakmicaDTO convert(Utakmica source) {
		UtakmicaDTO dto= new UtakmicaDTO();
		
		dto.setId(source.getId());
		dto.setReprezentacijaAId(source.getReprezentacijaA().getId());
		dto.setReprezentacijaANaziv(source.getReprezentacijaA().getNaziv());
		dto.setReprezentacijaASkraceno(source.getReprezentacijaA().getSkraceniNaziv());
		dto.setReprezentacijaBId(source.getReprezentacijaB().getId());
		dto.setReprezentacijaBNaziv(source.getReprezentacijaB().getNaziv());
		dto.setReprezentacijaBSkraceno(source.getReprezentacijaB().getSkraceniNaziv());
		dto.setBrojGolovaA(source.getBrojGolovaA());
		dto.setBrojGolovaB(source.getBrojGolovaB());
		
		return dto;
	}
	
	
	  public List<UtakmicaDTO> convert(List<Utakmica> utakmice){
	        List<UtakmicaDTO> utakmicaDTOs = new ArrayList<>();

	        for(Utakmica u : utakmice) {
	        	UtakmicaDTO dto = convert(u);
	        	utakmicaDTOs.add(dto);
	        }

	        return utakmicaDTOs;
	    }

}
