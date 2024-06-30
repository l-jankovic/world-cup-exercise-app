package com.ftn.modul3.zavrsni.jwd.Utakmice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.ftn.modul3.zavrsni.jwd.Utakmice.enumeration.KorisnickaUloga;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Igrac {
	
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @EqualsAndHashCode.Include
     @Setter(value = AccessLevel.NONE)
	  private Long id;
	 
	 @Column(nullable = false)
	 private String ime;
	 
	 
	 @Column(nullable = false)
	 private String prezime;
	 
	 
	 @ManyToOne
	 private Reprezentacija reprezentacija;
	 @Column
	 private int ukupnoGolova;

}
