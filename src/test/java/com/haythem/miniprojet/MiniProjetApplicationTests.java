package com.haythem.miniprojet;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.haythem.miniprojet.entities.Joueur;
import com.haythem.miniprojet.repos.JoueurRepository;
import com.haythem.miniprojet.service.JoueurService;

@SpringBootTest
class MiniProjetApplicationTests {

	@Autowired
	private JoueurRepository joueurRepository;
	@Autowired
	private JoueurService joueurService;
	@Test
	public void testCreateJoueur() {
	Joueur jou = new Joueur("Haythem Bekir",new Date());
	joueurRepository.save(jou);
	}
	 @Test
	 public void testFindJoueur()
	 {
	 Joueur j = joueurRepository.findById(1L).get();
	 System.out.println(j);
	 }
	 @Test
	 public void testUpdateJoueur()
	 {
	 Joueur j = joueurRepository.findById(1L).get();
	 j.setName("Med bekir");
	 joueurRepository.save(j);
	 }
	 @Test
	 public void testDeleteJoueur()
	 {
		 joueurRepository.deleteById(1L);;
		 }

	@Test
     public void testListerTousJoueur()
		 {
		 List<Joueur> jou = joueurRepository.findAll();
		 for (Joueur j : jou)
		 {
		 System.out.println(j);
		 }
		 }
	@Test
	public void testFindByNomProduitContains()
	{
	Page<Joueur> jou = joueurService.getAllJoueursParPage(0,2);
	System.out.println(jou.getSize());
	System.out.println(jou.getTotalElements());
	System.out.println(jou.getTotalPages());
	jou.getContent().forEach(p -> {System.out.println(p.toString());
	 });
	/*ou bien
	for (Joueur p : jou)
	{
	System.out.println(p);
	} */
	}
	
	


}
