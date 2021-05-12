package spring.learningjpa.sfgrecipeApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.learningjpa.sfgrecipeApp.service.RecipeService;


@Controller
public class IndexController {

	private final RecipeService recipeService;
	
	public IndexController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}
	
	@RequestMapping({"","/","index"})
	public String indexController(Model model) {
		model.addAttribute("recipes", recipeService.getRecipe());	
		return "index";
		
	}
}
