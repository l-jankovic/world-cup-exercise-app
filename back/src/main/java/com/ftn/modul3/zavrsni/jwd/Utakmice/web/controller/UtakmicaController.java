package com.ftn.modul3.zavrsni.jwd.Utakmice.web.controller;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.modul3.zavrsni.jwd.Utakmice.model.Utakmica;
import com.ftn.modul3.zavrsni.jwd.Utakmice.service.UtakmicaService;
import com.ftn.modul3.zavrsni.jwd.Utakmice.support.UtakmicaDtoToUtakmica;
import com.ftn.modul3.zavrsni.jwd.Utakmice.support.UtakmicaToUtakmicaDto;
import com.ftn.modul3.zavrsni.jwd.Utakmice.web.dto.UtakmicaDTO;



@RestController
@RequestMapping(value = "/api/utakmice",produces = MediaType.APPLICATION_JSON_VALUE)
public class UtakmicaController {
	
	

	@Autowired
	private UtakmicaService utakmicaService;
	
	@Autowired
	private UtakmicaDtoToUtakmica toUtakmica;
	
	@Autowired
	private UtakmicaToUtakmicaDto toDto;
	
	
	@PreAuthorize("hasRole('ROLE_KORISNIK')")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UtakmicaDTO> create (@Valid @RequestBody UtakmicaDTO utDTO){
		Utakmica u = toUtakmica.convert(utDTO);
		
		if(u.getReprezentacijaA()==null) {
			  return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		if(u.getReprezentacijaB()==null) {
			  return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Utakmica sacuvanaU= utakmicaService.save(u);
		
		
		return new ResponseEntity<>(toDto.convert(sacuvanaU),HttpStatus.OK);
		
	}
	 
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	 @DeleteMapping("/{id}")
		public ResponseEntity<Void> delete(@PathVariable Long id) {
		 Utakmica obrisanaU = utakmicaService.delete(id);

			if (obrisanaU != null) {

				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
	
	
	 @PreAuthorize("hasAnyRole('ROLE_KORISNIK', 'ROLE_ADMIN')")
	@PutMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UtakmicaDTO>update(@PathVariable Long id, @Valid @RequestBody UtakmicaDTO utDTO){
		
		
		if(!id.equals(utDTO.getId())) {
			  return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		
		Utakmica u = toUtakmica.convert(utDTO);
		if(u.getReprezentacijaA()==null) {
			  return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		if(u.getReprezentacijaB()==null) {
			  return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Utakmica sacuvanaU= utakmicaService.save(u);
		
		
		return new ResponseEntity<>(toDto.convert(sacuvanaU),HttpStatus.OK);
		
		
		
	}
	
	 	@PreAuthorize("hasRole('ROLE_KORISNIK')")
	  @GetMapping("/{id}")
	    public ResponseEntity<UtakmicaDTO> getOne(@PathVariable Long id){
		  Utakmica u  = utakmicaService.findOne(id);

	        if(u != null) {
	            return new ResponseEntity<>(toDto.convert(u), HttpStatus.OK);
	        }else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	  
	  
	  @PermitAll
	  @GetMapping()
	  public ResponseEntity<List<UtakmicaDTO>> getAll(
			  @RequestParam(required = false) Long repAId,
			  @RequestParam(required = false) Long  repBId,
			  @RequestParam(value = "pageNo",defaultValue = "0")int pageNo){
		  
		  Page<Utakmica>page;
		 
		  page=utakmicaService.search(repAId, repBId, pageNo);
	
		  HttpHeaders headers = new HttpHeaders();
	      headers.add("Total-Pages", Integer.toString(page.getTotalPages()));
	      
	      return new ResponseEntity<>(toDto.convert(page.getContent()), headers, HttpStatus.OK);
	  }
	  
	  	@PermitAll
		@PutMapping(value = "/goa/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<UtakmicaDTO> updateGoA(@PathVariable Long id){
			
		
			Utakmica u= utakmicaService.findOne(id);
			if(u==null) {
				  return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

			}else {
			
			

			  
			 Utakmica utakmicaS = utakmicaService.povecajGoA(id);
			
			  return new ResponseEntity<UtakmicaDTO>(toDto.convert(utakmicaS),HttpStatus.OK);
		}
			}
		
		
		@PermitAll
		@PutMapping(value = "/gob/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<UtakmicaDTO> updateGoB(@PathVariable Long id){
			
		
			Utakmica u= utakmicaService.findOne(id);
			if(u==null) {
				  return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

			}else {
			
			

			  
			 Utakmica utakmicaS = utakmicaService.povecajGoB(id);
			
			  return new ResponseEntity<UtakmicaDTO>(toDto.convert(utakmicaS),HttpStatus.OK);
		}
			}
	  
	  
	  
	  
	  @ExceptionHandler(value = DataIntegrityViolationException.class)
	    public ResponseEntity<Void> handle() {
	        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    }
	
	

}
