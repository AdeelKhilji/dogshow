package ca.sheridancollege.khiljimo.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.khiljimo.beans.DogBreed;
import ca.sheridancollege.khiljimo.beans.DogInfo;
import ca.sheridancollege.khiljimo.repositories.DogBreedRepository;
import ca.sheridancollege.khiljimo.repositories.DogInfoRepository;

@Controller
public class DogInfoController 
{
	@Autowired
	private DogBreedRepository dogBreedRepository;
	@Autowired
	private DogInfoRepository dogInfoRepository;
	
	@GetMapping("/dogList")
	public String getDogListPage(Model model)
	{
		model.addAttribute("ListOfDogs", dogInfoRepository.getListOfDogs());
		
		return "/DogInfo/dogList.html";
	}
	
	@GetMapping("/addDog")
	public String addDogPage(Model model)
	{
		ArrayList<DogBreed> breeds = dogBreedRepository.getDogBreeds();
		model.addAttribute("ListOfBreeds", breeds);
		model.addAttribute("dogInfo", new DogInfo());
		
		return "/DogInfo/addDog.html";
	}
	
	@PostMapping("/addDog")
	public String addDog(@ModelAttribute DogInfo dogInfo, Model model)
	{
		dogInfoRepository.addDog(dogInfo);
		
		return "redirect:/dogList";
	}
	
	@GetMapping("/updateDogInfo/{id}")
	public String updateDogPage(@PathVariable int id, Model model)
	{
		DogInfo dogInfo = dogInfoRepository.getDogById(id);
				
		ArrayList<DogBreed> breeds = dogBreedRepository.getDogBreeds();
		
		model.addAttribute("ListOfBreeds", breeds);
		
		model.addAttribute("dog", dogInfo);
		
		System.out.println(dogInfo);
		return "/DogInfo/updateDog.html";
	}
	
	@PostMapping("/updateDogInfo")
	public String updateDogInfo(@ModelAttribute DogInfo dogInfo, Model model)
	{
		dogInfoRepository.updateDogInfo(dogInfo);
		System.out.println(dogInfo);
		return "redirect:/dogList";
	}
	
	@GetMapping("/deleteDogInfo/{id}")
	public String deleteDogInfo(@PathVariable int id, Model model)
	{
		dogInfoRepository.deleteDogInfo(id);
		System.out.println(id);
		return "redirect:/dogList";
	}
}
