<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@	taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<c:import url="../views/jspf/resources.jsp" />
</head>
<body>
	<div class="row main-frame">
		<c:import url="../views/jspf/left-navbar.jsp" />
		<div class="col-md-9 botton-separator">
			<c:import url="../views/jspf/upper-navbar.jsp" />
			<div class="row botton-separator">
				<ul class="nav nav-tabs">
					<li class="active"><a href="#home" data-toggle="tab">Contenidos</a></li>
					<li><a href="#history" data-toggle="tab">Historial</a></li>
				</ul>
				<div id="myTabContent" class="tab-content">
					<div class="tab-pane fade active in" id="home">
						<div class="row content-left-separator search-content-line-height">
							<div id="page-content" class="col-md-12 page-content-style" >
							
							</div>
						</div>
					</div>
					<div class="tab-pane fade active" id="history">
						<div class="row content-left-separator welcome-title-separator hide-tab-content">
							<div class="col-md-4"></div>
							<div class="col-md-4">
								<h2></h2>
							</div>
							<div class="col-md-4"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script>
	var leyNorma = function(tipo, numero_norma, descripcion) {
		tipo = ko.observable(tipo);
		numero_norma = ko.observable(numero_norma);
		descripcion = ko.observable(descripcion);
	};

	var viewModel = {
		LeftMenu : ko.observableArray(),
		MenuTabs : ko.observableArray(),
		Tree : ko.observableArray(),
		Cultures : ko.observableArray(),
		MainContent : ko.observable(),
		NavigationLine : ko.observableArray(),
		SearchResults : ko.observableArray()
	};

	ko.applyBindings(viewModel, $('#page-content')[0]);
	
	$(document).ready(function() { 
		$.get( "${url}", function( data ) {
			  $( "#page-content" ).html(data);
			});
	});
	
	function redirectToPage(pageUrl) {
		window.location.replace(pageUrl);
	}

	//$(document).ready(function () {
	var data = [ "Ley de Transporte", "Ley Penal" ];

	//create AutoComplete UI component
	$("#countries").kendoAutoComplete({
		dataSource : data,
		filter : "startswith",
		placeholder : "Seleccione una ley...",
		separator : ", "
	});
	//});
</script>
<style>
@font-face {
	font-family: 'Glyphicons Halflings';
	src:
		url('../wikilaws/resources/images/glyphicons-halflings-regular.eot');
	src:
		url('../wikilaws/resources/images/glyphicons-halflings-regular.eot?#iefix')
		format('embedded-opentype'),
		url('../wikilaws/resources/images/glyphicons-halflings-regular.woff')
		format('woff'),
		url('../wikilaws/resources/images/glyphicons-halflings-regular.ttf')
		format('truetype'),
		url('../wikilaws/resources/images/glyphicons-halflings-regular.svg#glyphicons-halflingsregular')
		format('svg');
}
</style>
</html>
