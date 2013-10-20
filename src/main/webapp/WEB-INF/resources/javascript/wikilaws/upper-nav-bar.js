var viewModelUpperNavBar = {
		searchInput: ko.observable(),
		searchButtonClick : function() {
			var correctSearchinput = "";
			
			if( !jQuery.isEmptyObject(viewModelUpperNavBar.searchInput()) ){
				correctSearchinput = viewModelUpperNavBar.searchInput().toString();
			}
			correctSearchinput = $("#searchInput").val();
			redirectToPage("../wikilaws/resultados_busqueda.htm?searchInput=" + correctSearchinput);
		},
        saveInNavegationHistory : function(url, descripcion){
        	
        }
	};
	
ko.applyBindings(viewModelUpperNavBar, $('#upper-navbar')[0]);

$(document).ready(function() {
	
	$("#searchInput").kendoAutoComplete({
        minLength: 2,
        ignoreCase: true,
        template: '<a href="../wikilaws/contenido_pagina.htm?url=${data.url}">${data.tipo} ${data.numero_norma} ${data.descripcion} </a>',
        dataSource: {
        	serverFiltering: true,
            transport: {
                read:{
                    dataType: "json",
                    url: "../wikilaws/resultados_busqueda_ajax.htm"
                },
                parameterMap: function() {
                   return { searchInput: $("#searchInput").data("kendoAutoComplete").value() };
                }
            }
        },
    });
});