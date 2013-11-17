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
				</ul>
				<div id="myTabContent" class="tab-content">
					<div class="tab-pane fade active in" id="home">
						<div class="row content-left-separator search-content-line-height">
							<div id="page-content" class="col-md-12 page-content-style">
								<div class="row main-page-title-margins">
									<h4>Resultados de Busqueda</h4>
								</div>
								<c:choose>
									<c:when test="${!empty leyesYNormas}">
										<ul>
											<!-- data-bind="click: saveInNavegationHistory(${ley.url},${ley.descripcion})" -->
											<c:forEach items="${leyesYNormas}" var="ley">
												<li><a
													href="../wikilaws/contenido_pagina.htm?url=${ley.url}&id_normas=${ley.id_normas}">${ley.tipo}
														${ley.numero_norma} ${ley.descripcion} 
													</a><a href="../wikilaws/${ley.pdf}">   (Descargar Pdf)</a>
												</li>		
											</c:forEach>
										</ul>
									</c:when>
									<c:otherwise>
										<h5>Debe ingresar algún criterio de busqueda</h5>
									</c:otherwise>
								</c:choose>
							</div>
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
		NavigationLine : ko.observableArray()
	};

	ko.applyBindings(viewModel, $('#page-content')[0]);

	function redirectToPage(pageUrl) {
		window.location.replace(pageUrl);
	}
</script>
<script src="../wikilaws/resources/javascript/wikilaws/upper-nav-bar.js"
	type="text/javascript"></script>
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
