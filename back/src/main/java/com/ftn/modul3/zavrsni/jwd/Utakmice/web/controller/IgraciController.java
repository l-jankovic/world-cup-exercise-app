package com.ftn.modul3.zavrsni.jwd.Utakmice.web.controller;

import java.util.List;

import javax.annotation.security.PermitAll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.modul3.zavrsni.jwd.Utakmice.model.Igrac;
import com.ftn.modul3.zavrsni.jwd.Utakmice.model.Reprezentacija;
import com.ftn.modul3.zavrsni.jwd.Utakmice.model.Utakmica;
import com.ftn.modul3.zavrsni.jwd.Utakmice.service.IgracService;
import com.ftn.modul3.zavrsni.jwd.Utakmice.support.IgracToIgracDto;
import com.ftn.modul3.zavrsni.jwd.Utakmice.web.dto.IgracDTO;
import com.ftn.modul3.zavrsni.jwd.Utakmice.web.dto.ReprezentacijaDTO;
import com.ftn.modul3.zavrsni.jwd.Utakmice.web.dto.UtakmicaDTO;

@RestController
@RequestMapping(value = "/api/igraci",produces = MediaType.APPLICATION_JSON_VALUE)
public class IgraciController {
	
	
	@Autowired
	private IgracService igracService;
	
	@Autowired
	private IgracToIgracDto toDto;
	
	

	@PermitAll
	@GetMapping
	public ResponseEntity<List<IgracDTO>> getAll(){
		
		List<Igrac> reprezentacijas= igracService.findAll();
		
		
	        
	   return new ResponseEntity<>(toDto.convert(reprezentacijas),HttpStatus.OK);

	}
	
	
	@PermitAll
	@PutMapping(value = "/dodajgo/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<IgracDTO> updateGoB(@PathVariable Long id){
		
	
		Igrac i= igracService.findOne(id);
		if(i==null) {
			  return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}else {
		
		

		  
		 Igrac iSacuvan = igracService.uvecajGolove(id);
		
		  return new ResponseEntity<IgracDTO>(toDto.convert(iSacuvan),HttpStatus.OK);
	}
		}

}
