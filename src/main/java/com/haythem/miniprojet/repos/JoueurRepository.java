package com.haythem.miniprojet.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.haythem.miniprojet.entities.Joueur;

public interface JoueurRepository extends JpaRepository<Joueur, Long> {
	

}
