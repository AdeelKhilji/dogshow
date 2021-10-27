package ca.sheridancollege.khiljimo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.khiljimo.beans.DogBreed;
import ca.sheridancollege.khiljimo.repositories.DogBreedRepository;

@Controller
public class DogBreedController 
{
	@Autowired
	private DogBreedRepository dogBreedRepository;
	
	@GetMapping("/addBreed")
	public String getAddBreedPage(Model model)
	{
		model.addAttribute("dogBreeds", dogBreedRepository.getDogBreeds());
		model.addAttribute("dogBreed", new DogBreed());
		return "/DogBreed/addBreed.html";
	}
	
	@PostMapping("/addBreed")
	public String addBreed(@ModelAttribute DogBreed dogBreed)
	{
		dogBreedRepository.addDogBreed(dogBreed);
		return "redirect:/addBreed";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteDogBreed(@PathVariable int id, Model model)
	{
		dogBreedRepository.deleteDogBreed(id);
		return "redirect:/addBreed";
	}
}
