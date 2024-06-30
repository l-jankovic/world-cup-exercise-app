package com.ftn.modul3.zavrsni.jwd.Utakmice.web.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class ReprezentacijaDTO {
	
	
	private Long id;
	
	@NotBlank
	private String naziv;
	
	@Size(max = 3)
	private String skraceniNaziv;

}
