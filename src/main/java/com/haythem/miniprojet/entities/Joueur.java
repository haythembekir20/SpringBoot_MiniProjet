package com.haythem.miniprojet.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Joueur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@NotNull
	@Size (min = 4,max = 30)
	private String Name;
	


	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
	private Date datecreation;
	
	
	@ManyToOne
	 private Equipe equipe;
	
	
	public Equipe getEquipe() {
		return equipe;
	}



	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}



	public Joueur() {
		super();
	}
	
	
	
	public Joueur( String name, Date datecreation) {
		super();
		
		Name = name;
		this.datecreation = datecreation;
	}


	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Date getDatecreation() {
		return datecreation;
	}
	public void setDatecreation(Date datecreation) {
		this.datecreation = datecreation;
	}



	@Override
	public String toString() {
		return "Joueur [id=" + id + ", Name=" + Name + ", datecreation=" + datecreation + "]";
	}

	
}
