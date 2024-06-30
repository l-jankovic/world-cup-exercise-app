package com.ftn.modul3.zavrsni.jwd.Utakmice.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftn.modul3.zavrsni.jwd.Utakmice.model.Igrac;
import com.ftn.modul3.zavrsni.jwd.Utakmice.model.Utakmica;
import com.ftn.modul3.zavrsni.jwd.Utakmice.web.dto.IgracDTO;
import com.ftn.modul3.zavrsni.jwd.Utakmice.web.dto.UtakmicaDTO;

@Component
public class IgracToIgracDto  implements Converter<Igrac, IgracDTO>{

	@Override
	public IgracDTO convert(Igrac source) {
		IgracDTO dto = new IgracDTO();
		
		
		dto.setId(source.getId());
		dto.setIme(source.getIme());
		dto.setPrezime(source.getPrezime());
		dto.setUkupnoGolova(source.getUkupnoGolova());
		dto.setReprezentacijaId(source.getReprezentacija().getId());
		dto.setReprezentacijaNaziv(source.getReprezentacija().getNaziv());
		
		return dto;
	}
	
	  public List<IgracDTO> convert(List< Igrac> igraci){
	        List<IgracDTO> igracDTOs = new ArrayList<>();

	        for(Igrac i : igraci  ) {
	        	 IgracDTO dto = convert(i);
	        	 igracDTOs.add(dto);
	        }

	        return igracDTOs;
	    }


}
