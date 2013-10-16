var viewModelUpperNavBar = {
		searchInput: ko.observable(),
		searchButtonClick : function() {
			var correctSearchinput = "";
			
			if( !jQuery.isEmptyObject(viewModelUpperNavBar.searchInput()) ){
				correctSearchinput = viewModelUpperNavBar.searchInput().toString();
			}
			
			redirectToPage("../wikilaws/resultados_busqueda.htm?searchInput=" + correctSearchinput);
		},
        saveInNavegationHistory : function(url, descripcion){
        	
        }
	};
	
ko.applyBindings(viewModelUpperNavBar, $('#upper-navbar')[0]);