package com.haythem.miniprojet.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.haythem.miniprojet.entities.Joueur;

public interface JoueurService {
	Joueur saveJoueur(Joueur j);
	Joueur updateJoueur(Joueur j);
	void deleteJoueur(Joueur j);
	 void deleteJoueurById(Long id);
	 Joueur getJoueur(Long id);
	List<Joueur> getAllJoueur();
	Page<Joueur> getAllJoueursParPage(int page, int size);

}
