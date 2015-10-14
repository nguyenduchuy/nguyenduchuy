package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.service.IngredientService;
import ua.service.RecipeService;

@Controller
public class IngredientController {

	@Autowired
	private IngredientService ingredientService;

	@Autowired
	private RecipeService recipeService;

	@RequestMapping(value = "/ingredient/{id}")
	private String showIngredient(@PathVariable int id, Model model) {
		model.addAttribute("ingredient", recipeService.findById(id));
		return "ingredientprofile";
	}

	@RequestMapping(value = "/ingredient", method = RequestMethod.POST)
	private String saveIngredient(@RequestParam int recipeId,
			@RequestParam int amount, @RequestParam String ingredientName,
			@RequestParam String measuringSystemName) {
		ingredientService.save(recipeId, amount, ingredientName,
				measuringSystemName);
		return "redirect:/ingredient/" + recipeId+ ".html";
	}
}
