<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Le styles -->
<link href="./assets/css/bootstrap.css" rel="stylesheet">
<title>Save Commande</title>
<style type="text/css">

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
					<li><a href="listvoiture.do">Gestion voiture</a></li>
					<li class="active"><a href="listclient.do">Gestion client</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="content">
			<div class="page-header">
				<h1>
					Gestion Commande <small>Enregistrer une nouvelle commande</small>
				</h1>
			</div>
			<div class="row">
				<div class="span3">
					<ul class="nav pills stacked">
						<li class="active"><a href="#">Saisir</a></li>
						<li><a href="listcommande.do">Lister</a></li>
						<li><a href="#">Rechercher</a></li>
					</ul>
				</div>
				<div class="span7">
				<form:form action="savecommande.do" method="post" commandName="commande">
				<p>Nom du client :</p> <form:select id="champ" path="commandeKey.client.id">
					<form:option value="">Choisir un client</form:option>
									<c:forEach items="${clients}" var="c" >
											<form:option value="${c.id }">${c.name }  </form:option>
										</c:forEach>
							</form:select><br/>
							
			<p>Modele de la voiture :</p> <form:select id="champ" path="commandeKey.voiture.id">
								<form:option value="">Choisir une voiture</form:option>
										<c:forEach items="${voitures}" var="v" >
											<form:option value="${v.id }">${v.modele }  </form:option>
										</c:forEach>
							</form:select>
							
							<p>Date début de la commande : <form:input type="text" id="champ" path="dateDebutCommande"/></p>
							<p>Date fin de la commande : <form:input type="text" id="champ" path="dateFinCommande"/></p>
				<button type="submit" class="btn primary">Enregistrer</button>
				<button type="reset" class="btn">Annuler</button>
	</form:form>
</div>
</div>
	</div>

	<div id="lien">
	<a href="savevoiture.do"> Sauvegarder une nouvelle voiture</a><br/>
	<a href="listvoiture.do"> Lister les voitures disponibles</a><br/>
	<a href="saveclient.do"> Sauvegarder un nouveau client</a><br/>
	<a href="listclient.do"> lister un nouveau client</a><br/>
	<a href="savecommande.do"> Commander une voiture</a><br/>
	<a href="listcommande.do"> Lister les commandes</a><br/>
	<a href="saveemploye.do"> Sauvegarder un nouveau employe</a><br/>
	<a href="listemploye.do"> lister un nouveau employe</a><br/>
	</div>
	
	</div>
	
</body>
</html>