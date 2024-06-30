package com.ftn.modul3.zavrsni.jwd.Utakmice.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Reprezentacija {
	
	
	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   @EqualsAndHashCode.Include
	   @Setter(value = AccessLevel.NONE)
	    private Long id;
	   
	   
	   @Column(nullable = false,unique = true)
	   private String naziv;
	   
	   
	   @Column(length = 3,nullable = false,unique = true)
	   private String skraceniNaziv;
	   
	   
	   @OneToMany(mappedBy = "reprezentacija",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	   private List<Igrac> igraci = new ArrayList<>();
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   

}
