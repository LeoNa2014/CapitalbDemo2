<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="RecipeApp">
	<head>
		<title>Capitalb Demo Application - Leo Na</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta name="author" content="Leo Na">
		<meta name="description" content="Capitalb Demo Application">
		<!-- <link rel="stylesheet" type="text/css" href="//netdna.bootstrapcdn.com/bootstrap/2.3.2/css/bootstrap.min.css"> -->
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/bootstrap-2.3.2/css/bootstrap.css"/>" >
		<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" >
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/app.css"/>" >
	</head>
	<body>
		<div class="container-narrow">
			<h3 class="muted">Capitalb Demo Application - Leo Na</h3>
			<hr>
			<div class="row-fluid">
	        	<div class="span2">
					<div class="tabbable tabs-left">
						<ul class="nav nav-tabs">
							<li class="active"><a data-toggle="tab" href="#home">Home</a></li>
							<li><a data-toggle="tab" href="#newRecipe">New Recipe</a></li>
							<li><a data-toggle="tab" href="#recipes">All Recipes</a></li>
						</ul>
					</div>
				</div>
	        	<div class="span10">
	        		<div ng-view></div>
	        	</div>
	        </div>
		</div>
		<script type="text/javascript"> var _contextPath = "${pageContext.request.contextPath}"; </script>
		<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
		<script type="text/javascript" src="<c:url value="/resources/bootstrap-2.3.2/js/bootstrap.js"/>"></script>
		<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.25/angular.min.js"></script>
		<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.25/angular-route.js"></script>
		<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.25/angular-resource.js"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/app.js"/>"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/service.js"/>"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/controller.js"/>"></script>
		
	</body>
</html>