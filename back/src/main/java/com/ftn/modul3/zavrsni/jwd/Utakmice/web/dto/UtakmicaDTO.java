package com.ftn.modul3.zavrsni.jwd.Utakmice.web.dto;

import lombok.Data;

@Data
public class UtakmicaDTO {

	
	private Long id;
	
	
	private Long reprezentacijaAId;
	private String reprezentacijaANaziv;
	private String reprezentacijaASkraceno;
	
	private Long reprezentacijaBId;
	private String reprezentacijaBNaziv;
	private String reprezentacijaBSkraceno;
	
	
	
	private int brojGolovaA;
	
	
	
	private int brojGolovaB;
}
