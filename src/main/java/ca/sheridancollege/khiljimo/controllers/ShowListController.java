package ca.sheridancollege.khiljimo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ca.sheridancollege.khiljimo.repositories.ShowListRepository;

@Controller
public class ShowListController 
{
	@Autowired
	private ShowListRepository showListRepository;
	
	@GetMapping("/showList")
	public String getShowList(Model model)
	{
		model.addAttribute("breedOne", showListRepository.getDogsByBreed("Beagle").size());
		model.addAttribute("beagle",showListRepository.getDogsByBreed("Beagle").get(0));
		model.addAttribute("beagleCM",showListRepository.getDogsByCM("Beagle").size());
		model.addAttribute("beagleCF",showListRepository.getDogsByCF("Beagle").size());
		model.addAttribute("beagleSM",showListRepository.getDogsBySM("Beagle").size());
		model.addAttribute("beagleSF",showListRepository.getDogsBySF("Beagle").size());
		
		model.addAttribute("breedTwo", showListRepository.getDogsByBreed("Dachshund(MLH)").size());
		model.addAttribute("dMLH",showListRepository.getDogsByBreed("Dachshund(MLH)").get(0));
		model.addAttribute("dMLH_CM",showListRepository.getDogsByCM("Dachshund(MLH)").size());
		model.addAttribute("dMLH_CF",showListRepository.getDogsByCF("Dachshund(MLH)").size());
		model.addAttribute("dMLH_SM",showListRepository.getDogsBySM("Dachshund(MLH)").size());
		model.addAttribute("dMLH_SF",showListRepository.getDogsBySF("Dachshund(MLH)").size());
		
		model.addAttribute("breedThree", showListRepository.getDogsByBreed("Dachshund(MS)").size());
		model.addAttribute("dMS",showListRepository.getDogsByBreed("Dachshund(MS)").get(0));
		model.addAttribute("dMS_CM",showListRepository.getDogsByCM("Dachshund(MS)").size());
		model.addAttribute("dMS_CF",showListRepository.getDogsByCF("Dachshund(MS)").size());
		model.addAttribute("dMS_SM",showListRepository.getDogsBySM("Dachshund(MS)").size());
		model.addAttribute("dMS_SF",showListRepository.getDogsBySF("Dachshund(MS)").size());
		
		model.addAttribute("breedFour", showListRepository.getDogsByBreed("Dachshund(SLH)").size());
		model.addAttribute("dSLH",showListRepository.getDogsByBreed("Dachshund(SLH)").get(0));
		model.addAttribute("dSLH_CM",showListRepository.getDogsByCM("Dachshund(SLH)").size());
		model.addAttribute("dSLH_CF",showListRepository.getDogsByCF("Dachshund(SLH)").size());
		model.addAttribute("dSLH_SM",showListRepository.getDogsBySM("Dachshund(SLH)").size());
		model.addAttribute("dSLH_SF",showListRepository.getDogsBySF("Dachshund(SLH)").size());
		
		model.addAttribute("breedFive", showListRepository.getDogsByBreed("Whippet").size());
		model.addAttribute("Whip",showListRepository.getDogsByBreed("Whippet").get(0));
		model.addAttribute("Whip_CM",showListRepository.getDogsByCM("Whippet").size());
		model.addAttribute("Whip_CF",showListRepository.getDogsByCF("Whippet").size());
		model.addAttribute("Whip_SM",showListRepository.getDogsBySM("Whippet").size());
		model.addAttribute("Whip_SF",showListRepository.getDogsBySF("Whippet").size());
		
		model.addAttribute("breedSix", showListRepository.getDogsByBreed("Afghan Hound").size());
		model.addAttribute("Afg",showListRepository.getDogsByBreed("Afghan Hound").get(0));
		model.addAttribute("Afg_CM",showListRepository.getDogsByCM("Afghan Hound").size());
		model.addAttribute("Afg_CF",showListRepository.getDogsByCF("Afghan Hound").size());
		model.addAttribute("Afg_SM",showListRepository.getDogsBySM("Afghan Hound").size());
		model.addAttribute("Afg_SF",showListRepository.getDogsBySF("Afghan Hound").size());

		model.addAttribute("breedSeven", showListRepository.getDogsByBreed("Borzoi").size());
		model.addAttribute("Bor",showListRepository.getDogsByBreed("Borzoi").get(0));
		model.addAttribute("Bor_CM",showListRepository.getDogsByCM("Borzoi").size());
		model.addAttribute("Bor_CF",showListRepository.getDogsByCF("Borzoi").size());
		model.addAttribute("Bor_SM",showListRepository.getDogsBySM("Borzoi").size());
		model.addAttribute("Bor_SF",showListRepository.getDogsBySF("Borzoi").size());
		
		model.addAttribute("breedEight", showListRepository.getDogsByBreed("Deerhound").size());
		model.addAttribute("Deer",showListRepository.getDogsByBreed("Deerhound").get(0));
		model.addAttribute("Deer_CM",showListRepository.getDogsByCM("Deerhound").size());
		model.addAttribute("Deer_CF",showListRepository.getDogsByCF("Deerhound").size());
		model.addAttribute("Deer_SM",showListRepository.getDogsBySM("Deerhound").size());
		model.addAttribute("Deer_SF",showListRepository.getDogsBySF("Deerhound").size());
		
		model.addAttribute("breedNine", showListRepository.getDogsByBreed("Greyhound").size());
		model.addAttribute("Grey",showListRepository.getDogsByBreed("Greyhound").get(0));
		model.addAttribute("Grey_CM",showListRepository.getDogsByCM("Greyhound").size());
		model.addAttribute("Grey_CF",showListRepository.getDogsByCF("Greyhound").size());
		model.addAttribute("Grey_SM",showListRepository.getDogsBySM("Greyhound").size());
		model.addAttribute("Grey_SF",showListRepository.getDogsBySF("Greyhound").size());
		
		model.addAttribute("breedTen", showListRepository.getDogsByBreed("Irish Wolfhound").size());
		model.addAttribute("Irish",showListRepository.getDogsByBreed("Irish Wolfhound").get(0));
		model.addAttribute("Irish_CM",showListRepository.getDogsByCM("Irish Wolfhound").size());
		model.addAttribute("Irish_CF",showListRepository.getDogsByCF("Irish Wolfhound").size());
		model.addAttribute("Irish_SM",showListRepository.getDogsBySM("Irish Wolfhound").size());
		model.addAttribute("Irish_SF",showListRepository.getDogsBySF("Irish Wolfhound").size());

		
		return "/List/showList.html";
	}

}
