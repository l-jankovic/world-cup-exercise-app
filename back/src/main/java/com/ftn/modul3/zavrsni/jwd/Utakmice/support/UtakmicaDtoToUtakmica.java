package com.ftn.modul3.zavrsni.jwd.Utakmice.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftn.modul3.zavrsni.jwd.Utakmice.model.Utakmica;
import com.ftn.modul3.zavrsni.jwd.Utakmice.service.ReprezentacijaService;
import com.ftn.modul3.zavrsni.jwd.Utakmice.service.UtakmicaService;
import com.ftn.modul3.zavrsni.jwd.Utakmice.web.dto.UtakmicaDTO;

@Component
public class UtakmicaDtoToUtakmica implements Converter<UtakmicaDTO, Utakmica>{

	@Autowired
	private UtakmicaService utakmicaService;
	
	@Autowired 
	private ReprezentacijaService reprezentacijaService;
	
	@Override
	public Utakmica convert(UtakmicaDTO source) {
			
		Utakmica u = null;
		
		if(source.getId()==null) {
			u= new Utakmica();
			
		}else {
			u= utakmicaService.findOne(source.getId());
			
		}
		
		
		if(u!=null) {
			u.setReprezentacijaA(reprezentacijaService.findOne(source.getReprezentacijaAId()));
			u.setBrojGolovaA(source.getBrojGolovaA());
			u.setReprezentacijaB(reprezentacijaService.findOne(source.getReprezentacijaBId()));
			u.setBrojGolovaB(source.getBrojGolovaB());
		
			
		}
		
		return u;
	}

}
