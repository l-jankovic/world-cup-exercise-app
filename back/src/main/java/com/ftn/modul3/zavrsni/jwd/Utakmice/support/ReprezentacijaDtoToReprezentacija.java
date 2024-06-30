package com.ftn.modul3.zavrsni.jwd.Utakmice.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftn.modul3.zavrsni.jwd.Utakmice.model.Reprezentacija;
import com.ftn.modul3.zavrsni.jwd.Utakmice.model.Utakmica;
import com.ftn.modul3.zavrsni.jwd.Utakmice.service.ReprezentacijaService;
import com.ftn.modul3.zavrsni.jwd.Utakmice.web.dto.ReprezentacijaDTO;
import com.ftn.modul3.zavrsni.jwd.Utakmice.web.dto.UtakmicaDTO;

@Component
public class ReprezentacijaDtoToReprezentacija implements Converter<ReprezentacijaDTO, Reprezentacija> {
	
	@Autowired 
	private ReprezentacijaService reprezentacijaService;
	
	@Override
	public Reprezentacija convert(ReprezentacijaDTO source) {
		
		Reprezentacija r = null;
		
		if(source.getId()==null) {
			r= new Reprezentacija();
		}else {
			r= reprezentacijaService.findOne(source.getId());
		}
		
		if(r!=null) {
			r.setNaziv(source.getNaziv());
			r.setSkraceniNaziv(source.getSkraceniNaziv());
			
		}
		
		return r;
		
	}

}
