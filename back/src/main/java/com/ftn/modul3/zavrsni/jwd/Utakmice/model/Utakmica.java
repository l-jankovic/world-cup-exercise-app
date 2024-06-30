package com.ftn.modul3.zavrsni.jwd.Utakmice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Utakmica {
	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @EqualsAndHashCode.Include
		@Setter(value = AccessLevel.NONE)
	    private Long id;
		
		
		@ManyToOne
		private Reprezentacija reprezentacijaA;
		
		
		@ManyToOne
		private Reprezentacija reprezentacijaB;
		
		
		
		@Column 
		private int brojGolovaA;
		
		
		@Column
		private int brojGolovaB;
		
		

}
