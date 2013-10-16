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

$(document).ready(function() {
    $("#searchInput").kendoAutoComplete({
        dataTextField: "ProductName",
        filter: "contains",
        minLength: 3,
        dataSource: {
            type: "odata",
            serverFiltering: true,
            serverPaging: true,
            pageSize: 20,
            transport: {
                read: "http://demos.kendoui.com/service/Northwind.svc/Products"
            }
        }
    });
});