package com.haythem.miniprojet.controllers;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.haythem.miniprojet.entities.Joueur;
import com.haythem.miniprojet.service.JoueurService;

@Controller
public class JoueurController {
@Autowired
JoueurService joueurService;
@RequestMapping("/Search")
public String Search(ModelMap modelMap)
{
return "Search";
}



@RequestMapping("/showCreate")
public String showCreate(ModelMap modelMap)
{
modelMap.addAttribute("joueur", new Joueur());
return "createJoueur";
}
@RequestMapping("/saveJoueur")
public String saveJoueur(@Valid Joueur joueur,
		                               BindingResult bindingResult)
{
if (bindingResult.hasErrors())return "createJoueur";	
joueurService.saveJoueur(joueur);
return "createJoueur";
	
}


@RequestMapping("/ListeJoueurs")
public String listeJoueurs(ModelMap modelMap,
		@RequestParam (name="page",defaultValue = "0") int page,
		@RequestParam (name="size", defaultValue = "2") int size)

{
	
Page<Joueur> jou = joueurService.getAllJoueursParPage(page, size);
modelMap.addAttribute("Joueurs", jou);
modelMap.addAttribute("pages", new int[jou.getTotalPages()]);
modelMap.addAttribute("currentPage", page);
return "ListeJoueurs";

}


@RequestMapping("/supprimerJoueur")
public String supprimerJoueur(@RequestParam("id") Long id,
ModelMap modelMap,
@RequestParam (name="page",defaultValue = "0") int page,
@RequestParam (name="size", defaultValue = "2") int size)

{
	joueurService.deleteJoueurById(id);
	Page<Joueur> jou = joueurService.getAllJoueursParPage(page,size);
	modelMap.addAttribute("Joueurs", jou);
	modelMap.addAttribute("pages", new int[jou.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("size", size);
	return "ListeJoueurs";
	

}


@RequestMapping("/modifierJoueur")
public String editerJoueur(@RequestParam("id") Long id,ModelMap modelMap)
{
Joueur j= joueurService.getJoueur(id);
modelMap.addAttribute("joueur", j);
return "editerJoueur";
}

@RequestMapping("/updateJoueur")
public String updateJoueur(@ModelAttribute("joueur") Joueur joueur,
                            @RequestParam("date") String date,
                             ModelMap modelMap) throws ParseException

{


SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
Date dateCreation = dateformat.parse(String.valueOf(date));
joueur.setDatecreation(dateCreation);
joueurService.updateJoueur(joueur);
List<Joueur> jou = joueurService.getAllJoueur();
modelMap.addAttribute("Joueurs", jou);
return "ListeJoueurs";

}

}
