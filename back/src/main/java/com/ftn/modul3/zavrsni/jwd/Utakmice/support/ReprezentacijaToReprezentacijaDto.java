package com.ftn.modul3.zavrsni.jwd.Utakmice.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftn.modul3.zavrsni.jwd.Utakmice.model.Reprezentacija;
import com.ftn.modul3.zavrsni.jwd.Utakmice.model.Utakmica;
import com.ftn.modul3.zavrsni.jwd.Utakmice.web.dto.ReprezentacijaDTO;
import com.ftn.modul3.zavrsni.jwd.Utakmice.web.dto.UtakmicaDTO;

@Component
public class ReprezentacijaToReprezentacijaDto implements Converter<Reprezentacija, ReprezentacijaDTO> {

	@Override
	public ReprezentacijaDTO convert(Reprezentacija source) {
		
		ReprezentacijaDTO dto = new ReprezentacijaDTO();
		
		dto.setId(source.getId());
		dto.setNaziv(source.getNaziv());
		dto.setSkraceniNaziv(source.getSkraceniNaziv());
		
		
		return dto;
	}
	
	
	  public List<ReprezentacijaDTO> convert(List<Reprezentacija> reprezentacije){
	        List<ReprezentacijaDTO> repDTOs = new ArrayList<>();

	        for(Reprezentacija r : reprezentacije) {
	        	ReprezentacijaDTO dto = convert(r);
	        	repDTOs.add(dto);
	        }

	        return repDTOs;
	    }

}
