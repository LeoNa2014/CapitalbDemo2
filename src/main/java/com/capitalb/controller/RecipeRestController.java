package com.capitalb.controller;

import com.capitalb.model.Recipe;
import com.capitalb.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Handles restful requests for Recipes
 *
 * @author Leo Na
 */
@Controller
@RequestMapping(value = "/rest/recipe")
public class RecipeRestController {

	@Autowired
	private RecipeService recipeService;

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<Recipe> getAllRecipes(){
		return recipeService.getAll();
	}

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Recipe getRecipeById( @PathVariable("id") Long id ) {
		Recipe recipe = recipeService.getById( id );
		if ( recipe == null )
			throw new RecipeNotFoundException( id );
		return recipe;
	}

    @RequestMapping(value = "/new", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String registerNewRecipe( @RequestBody Recipe newRecipe ) {

		recipeService.register( newRecipe );
		return "{\"message\":\"Recipe (" + newRecipe.getName() + ") has been created\"}";
	}

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String removeRecipe( @PathVariable("id") Long id ) {
		Recipe recipe = recipeService.getById( id );
		if ( recipe == null )
			throw new RecipeNotFoundException( id );
		recipeService.remove( id );
		return "{\"message\":\"Recipe (" + recipe.getName() + ") has been removed\"}";
	}

    @ResponseStatus(HttpStatus.NOT_FOUND)
    public class RecipeNotFoundException extends RuntimeException {
		private static final long serialVersionUID = -8326787809556557515L;

		public RecipeNotFoundException( Long id ) {
			super( "Recipe (" + id + ") not found." );
		}
	}
}
