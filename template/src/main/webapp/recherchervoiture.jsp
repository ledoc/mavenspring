<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Carrental JSF</title>
<meta name="description" content="">
<meta name="author" content="">

<!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

<!-- Le styles -->
<link href="./assets/css/bootstrap.css" rel="stylesheet">
<style type="text/css">
/* Override some defaults */
html,body {
	background-color: #eee;
}

body {
	padding-top: 40px;
	/* 40px to make the container go all the way to the bottom of the topbar */
}

.container>footer p {
	text-align: center; /* center align it with the container */
}

.container {
	width: 820px;
	/* downsize our container to make the content feel a bit tighter and more cohesive. NOTE: this removes two full columns from the grid, meaning you only go to 14 columns and not 16. */
}

/* The white background content wrapper */
.content {
	background-color: #fff;
	padding: 20px;
	margin: 0 -20px 18px;
	/* negative indent the amount of the padding to maintain the grid system */
	-webkit-border-radius: 0 0 6px 6px;
	-moz-border-radius: 0 0 6px 6px;
	border-radius: 0 0 6px 6px;
	-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .15);
	-moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .15);
	box-shadow: 0 1px 2px rgba(0, 0, 0, .15);
}

/* Page header tweaks */
.page-header {
	background-color: #f5f5f5;
	padding: 20px 20px 10px;
	margin: -20px -20px 20px;
}

/* Styles you shouldn't keep as they are for displaying this base example only */
.content .span7,.content .span3 {
	min-height: 500px;
}
/* Give a quick and non-cross-browser friendly divider */
.content .span3 {
	margin-left: 0;
	padding-left: 19px;
	border-left: 1px solid #eee;
}
</style>

<!-- Le fav and touch icons -->
<link rel="shortcut icon" href="images/favicon.ico">
<link rel="apple-touch-icon" href="images/apple-touch-icon.png">
<link rel="apple-touch-icon" sizes="72x72"
	href="images/apple-touch-icon-72x72.png">
<link rel="apple-touch-icon" sizes="114x114"
	href="images/apple-touch-icon-114x114.png">
</head>

<body>

	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<a class="brand" href="#">MyCarRental-App</a>
				<ul class="nav">
					<li class="active"><a href="listvoiture.do">Gestion voiture</a></li>
					<li><a href="listeclient.do">Gestion client</a></li>
					<li><a href="listeemploye.do">Gestion employe</a></li>
				</ul>
			</div>
		</div>
	</div>

	<div class="container">

		<div class="content">
			<div class="page-header">
				<h1>
					Gestion voiture <small>Rechercher une voiture</small>
				</h1>
			</div>
			<div class="row">
				<div class="span3">

					<ul class="nav pills stacked">
						<li><a href="savevoiture.do">Saisir</a></li>
						<li><a href="listvoiture.do">Lister</a></li>
						<li class="active"><a href="#">Rechercher</a></li>
					</ul>
				</div>
				<div class="span7">

					<form:form class="form-search" action="recherchevoiture.do" method="post" commandName="voiture">
						<form:input type="text" class="input-medium search-query"
							placeholder="Marque/modele" path="marque"/>
						<form:button type="submit" class="btn"><a class="btn success" href="listvoiture.do?id=${v.id}">Rechercher</a></form:button>
					</form:form>



					<table class="table table-bordered table-striped">

						<thead>
							<tr>
								<th>#</th>
								<th>Marque</th>
								<th>Modele</th>
								<th>Date mise en circu.</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${voitures}" var="v" >
							<tr>
									<td>1</td>
									<td>${v.marque}</td>
									<td>${v.modele}</td>
									<td>12/06/2001</td>
									<td><security:authorize ifAllGranted="ROLE_ADMIN"><a class="btn danger" href="remove.do?id=${v.id}">Supprimer</a></security:authorize> <a
										class="btn success" href="savevoiture.do?id=${v.id}">Modifier</a></td>
							</tr>
						</c:forEach>	
						</tbody>

					</table>

				</div>


			</div>
		</div>

		<footer>
			<p>&copy; Formation Java - Treeptik</p>
		</footer>

	</div>
					<div id="lien">
	<a href="savevoiture.do"> Sauvegarder une nouvelle voiture</a><br/>
	<a href="listvoiture.do"> Lister les voitures disponibles</a><br/>
	<a href="saveclient.do"> Sauvegarder un nouveau client</a><br/>
	<a href="listclient.do"> lister un nouveau client</a><br/>
	<a href="listcommande.do"> Lister les commandes</a><br/>
	<a href="saveemploye.do"> Sauvegarder un nouveau employe</a><br/>
	<a href="listemploye.do"> lister un nouveau employe</a><br/>
	<a href="savecommande.do"> Commander une voiture</a><br/>
	</div>

</body>
</html>