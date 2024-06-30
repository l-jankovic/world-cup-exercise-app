package com.ftn.modul3.zavrsni.jwd.Utakmice.web.controller;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.modul3.zavrsni.jwd.Utakmice.model.Igrac;
import com.ftn.modul3.zavrsni.jwd.Utakmice.model.Reprezentacija;
import com.ftn.modul3.zavrsni.jwd.Utakmice.service.IgracService;
import com.ftn.modul3.zavrsni.jwd.Utakmice.service.ReprezentacijaService;
import com.ftn.modul3.zavrsni.jwd.Utakmice.support.IgracToIgracDto;
import com.ftn.modul3.zavrsni.jwd.Utakmice.support.ReprezentacijaDtoToReprezentacija;
import com.ftn.modul3.zavrsni.jwd.Utakmice.support.ReprezentacijaToReprezentacijaDto;
import com.ftn.modul3.zavrsni.jwd.Utakmice.web.dto.IgracDTO;
import com.ftn.modul3.zavrsni.jwd.Utakmice.web.dto.ReprezentacijaDTO;

@RestController
@RequestMapping(value = "/api/reprezentacije")
public class ReprezentacijaController {
	
	
	@Autowired
	private ReprezentacijaService reprezentacijaService;
	
	@Autowired
	private ReprezentacijaToReprezentacijaDto toDto;
	@Autowired
	private IgracService igracService;
	@Autowired
	private IgracToIgracDto toDtoIgrac;
	
	@PermitAll
	@GetMapping
	public ResponseEntity<List<ReprezentacijaDTO>> getAll(){
		
		List<Reprezentacija> reprezentacijas= reprezentacijaService.findAll();
		
		
	        
	   return new ResponseEntity<>(toDto.convert(reprezentacijas),HttpStatus.OK);

	}
	
	
	
	 @PermitAll
    @GetMapping("/{id}/igraci")
    public ResponseEntity<List<IgracDTO>> findByFilmId(@PathVariable @Positive(message = "Id must be positive.")  Long id){
        List<Igrac> igraci = igracService.getByReprezentacijaId(id);

        return new ResponseEntity<>(toDtoIgrac.convert(igraci), HttpStatus.OK);
    }


}
