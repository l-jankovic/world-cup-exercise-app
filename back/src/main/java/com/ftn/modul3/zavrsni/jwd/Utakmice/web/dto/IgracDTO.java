package com.ftn.modul3.zavrsni.jwd.Utakmice.web.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
public class IgracDTO {
	
	private Long id;
	
	private String ime;
	
	private String prezime;
	
	private int ukupnoGolova;
	private Long reprezentacijaId;
	private String reprezentacijaNaziv;

}
