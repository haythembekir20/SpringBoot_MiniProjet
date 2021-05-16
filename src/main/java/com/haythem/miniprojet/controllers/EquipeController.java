package com.haythem.miniprojet.controllers;

import java.text.ParseException;
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

import com.haythem.miniprojet.entities.Equipe;
import com.haythem.miniprojet.service.EquipeService;

@Controller
public class EquipeController {
	
	@Autowired
	EquipeService equipeService;
	@RequestMapping("/showCreateEqu")
	public String showCreateEqu(ModelMap modelMap)
	{
	modelMap.addAttribute("equipe", new Equipe());
	return "createEquipe";
	}
	@RequestMapping("/saveEquipe")
	public String saveEquipe(@Valid Equipe equipe,
			                               BindingResult bindingResult)
	{
	if (bindingResult.hasErrors())return "createEquipe";	
	equipeService.saveEquipe(equipe);
	return "createEquipe";
		
	}


	@RequestMapping("/ListeEquipes")
	public String listeEquipes(ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size)

	{
	Page<Equipe> equ = equipeService.getAllEquipesParPage(page, size);
	modelMap.addAttribute("Equipes", equ);
	modelMap.addAttribute("pages", new int[equ.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	return "ListeEquipes";

	}


	@RequestMapping("/supprimerEquipe")
	public String supprimerEquipe(@RequestParam("id") Long id,
	ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "2") int size)

	{
		equipeService.deleteEquipeById(id);
		Page<Equipe> equ = equipeService.getAllEquipesParPage(page,size);
		modelMap.addAttribute("Equipes", equ);
		modelMap.addAttribute("pages", new int[equ.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "ListeEquipes";
		

	}


	@RequestMapping("/modifierEquipe")
	public String editerEquipe(@RequestParam("id") Long id,ModelMap modelMap)
	{
	Equipe e= equipeService.getEquipe(id);
	modelMap.addAttribute("Equipe", e);
	return "editerEquipe";
	}

	@RequestMapping("/updateEquipe")
	public String updateEquipe(@ModelAttribute("equipe") Equipe equipe,
	                            @RequestParam("date") String date,
	                             ModelMap modelMap) throws ParseException

	{


	
	equipeService.updateEquipe(equipe);
	List<Equipe> equ = equipeService.getAllEquipe();
	modelMap.addAttribute("Equipes", equ);
	return "ListeEquipes";

	}
}
