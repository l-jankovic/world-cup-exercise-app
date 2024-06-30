package com.ftn.modul3.zavrsni.jwd.Utakmice.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftn.modul3.zavrsni.jwd.Utakmice.model.Igrac;
import com.ftn.modul3.zavrsni.jwd.Utakmice.service.IgracService;
import com.ftn.modul3.zavrsni.jwd.Utakmice.service.ReprezentacijaService;
import com.ftn.modul3.zavrsni.jwd.Utakmice.web.dto.IgracDTO;

@Component
public class IgracDtoToIgrac implements Converter<IgracDTO, Igrac> {

	@Autowired
	private IgracService igracService;
	
	@Autowired
	private ReprezentacijaService reprezentacijaService;
	
	@Override
	public Igrac convert(IgracDTO source) {
		
		Igrac i= null;
		
		if(source.getId()==null) {
			i= new Igrac();
		}else {
			i= igracService.findOne(source.getId());
		}
		
		
		if(i!=null) {
			
			i.setIme(source.getIme());
			i.setPrezime(source.getPrezime());
			i.setUkupnoGolova(source.getUkupnoGolova());
			i.setReprezentacija(reprezentacijaService.findOne(source.getReprezentacijaId()));
		}
		
		return i;
	}

}
