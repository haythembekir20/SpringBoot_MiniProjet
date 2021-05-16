package com.haythem.miniprojet.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Equipe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdEqu;
	private String nom;
	private String description;
	 
	@OneToMany(mappedBy = "equipe")
	private List<Joueur> joueurs;
	
	
	public Equipe() {
		super();
		
	}
	public Equipe(Long idEqu, String nom, String description) {
		super();
		IdEqu = idEqu;
		this.nom = nom;
		this.description = description;
	}
	public Long getIdEqu() {
		return IdEqu;
	}
	public void setIdEqu(Long idEqu) {
		IdEqu = idEqu;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Joueur> getJoueurs() {
		return joueurs;
	}
	public void setJoueurs(List<Joueur> joueurs) {
		this.joueurs = joueurs;
	}
	@Override
	public String toString() {
		return "Equipe [IdEqu=" + IdEqu + ", nom=" + nom + ", description=" + description + ", joueurs=" + joueurs
				+ "]";
	}
	
	
}
