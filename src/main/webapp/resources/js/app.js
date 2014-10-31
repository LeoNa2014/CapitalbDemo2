"use strict";

/* Recipe App Module */

var recipeApp = angular.module( "RecipeApp", [ "ngRoute", "ngResource" ] );

recipeApp.config( function( $routeProvider ) {
	$routeProvider.when( "/newRecipe", {
		controller : "NewRecipeCtrl",
		templateUrl : "templates/newRecipe.html"
	}).when( "/recipes", {
		controller : "RecipesCtrl",
		templateUrl : "templates/recipes.html"
	}).otherwise({
		controller : "RecipeHomeCtrl",
		templateUrl: "templates/home.html"
	});
});