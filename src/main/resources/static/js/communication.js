$(document).ready(function() {
	
	var refreshInterval = setInterval(ajaxInterval(), 10000);

    var currentLocation = window.location.pathname;
    var currentLocationSplit = currentLocation.split('/');
    var type = currentLocationSplit[1];
    var gare = currentLocationSplit[2];

    $("button").click(function(e) {
        console.log("BOUTON CLIQUE");
        e.preventDefault();
        $.ajax({
            type: "POST",
            url: "/testAdd"
        });
    });
    
    function ajaxInterval() {
    	
    	$('#resultsList').load('/update',{type:type, gare:gare});
    }
    
    setInterval(function() {
    	clearInterval(refreshInterval);
    	slider();
    }, 10000);
});
