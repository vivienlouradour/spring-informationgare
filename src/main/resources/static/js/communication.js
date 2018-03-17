
$(document).ready(function() {

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

    setInterval(function(){
        $('#resultsList').load('/update',{type:type, gare:gare});
    },1000);
});

