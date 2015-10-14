package ua.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.domain.Recipe;
import ua.service.RecipeService;

@Controller
public class RecipeController {

	@Autowired
	private RecipeService recipeService;

	@RequestMapping(value = "/recipes")
	private String showAllRecipes(Model model) {
		List<Recipe> recipes = recipeService.findAll();
		model.addAttribute("recipes", recipes);
		return "recipe";
	}

	@RequestMapping(value = "/recipe/{id}")
	private String showRecipe(Model model, @PathVariable int id) {
		model.addAttribute("recipe", recipeService.findById(id));
		return "recipeprofile";
	}

	@RequestMapping(value = "/recipe", method = RequestMethod.POST)
	public String createRecipe(
			@RequestParam("countryName") String countryName,
			@RequestParam("cookTime") String cookTime,
			@RequestParam("recipeName") String recipeName) {
		int recipeId = recipeService.save(countryName, cookTime, recipeName);
		return "redirect:/ingredient/" + recipeId + ".html";
	}

	@RequestMapping(value = "/recipeupdate", method = RequestMethod.POST)
	private String updateRecipe(@RequestParam int id,
			@RequestParam String countryName, @RequestParam String cookTime,
			@RequestParam String recipeName) {
		recipeService.update(id, countryName, cookTime, recipeName);
		return "redirect:/recipes.html";
	}

	@RequestMapping(value = "delete/recipe/{id}")
	private String deleteRecipe(@PathVariable int id) {
		recipeService.delete(id);
		return "redirect:/recipes.html";
	}
}
