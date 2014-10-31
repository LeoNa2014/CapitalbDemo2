"use strict";

/* Controllers */

/* Home Controller */
recipeApp.controller( "RecipeHomeCtrl", [ "$scope", function($scope) {} ] );

/* Recipes Controller */
recipeApp.controller( "RecipesCtrl", [ "$scope","recipeService", function( $scope, recipeService ) {	

	// Load all recipes
	recipeService.getRecipes( $scope );		

	// Add 'remove' function
	$scope.removeRecipe = function( id ) {

		// Call recipeService to remove a recipe
		recipeService.removeRecipe( id, $scope );

		// Remove recipe from existing table column
		$scope.recipes = $scope.recipes.filter( function( recipe ) {
			return recipe.id !== id;
		} );
	};
} ] );

/* New Recipe Controller */
recipeApp.controller( "NewRecipeCtrl", [ "$scope","recipeService", function( $scope, recipeService ) {				

	// Load all recipes
	recipeService.getRecipes( $scope );	

	// Add 'create' function
	$scope.createNewRecipe = function() {

		// build recipe ingredients
		var ingredients = [];
		$( ".ingredientName" ).each(function() {
			var ingredientName = $.trim( $(this).val() );
			if ( ingredientName != '' )
				ingredients.push( { "name": ingredientName } );
		});
		$scope.recipe.ingredients = ingredients;

		// Call recipeService to create a new recipe
		recipeService.createRecipe( $scope.recipe, $scope );

		// Push new recipe to existing table column
		$scope.recipes.push( $scope.recipe );

		// Reset fields values
		$scope.recipe = null;
		$scope.ingredientNames = "";
		$( ".ingredientName" ).val("");
	};		
} ] );