$(document).ready(function () {

    var currentLocation = window.location.pathname;
    var currentLocationSplit = currentLocation.split('/');
    var type = currentLocationSplit[1];
    var gare = currentLocationSplit[2];
    var nbRows = $('#container').find('tr').length;

    $("button").click(function (e) {
        console.log("BOUTON CLIQUE");
        e.preventDefault();
        $.ajax({
            type: "POST",
            url: "/testAdd"
        });
    });

    function resetScroll(){
        clearInterval(scrollThread);
        var delayScroll = 10000 + 2* 200 * nbRows;
        console.log(nbRows);
        console.log(delayScroll);
        scrollThread = setInterval(scrollDownAndUp, delayScroll);

    }

    function scrollDownAndUp() {
        if ($('#container').height() > $(window).height() - 70) {
            var nbRows = $('#container').find('tr').length;
            var time = 200 * nbRows;
            console.log(nbRows);
            $('body,html').animate({scrollTop: $(document).height()-$(window).height()}, time).delay(2000);
            $('body,html').animate({scrollTop: 0}, time).delay(10000);
        }
    }

    var scrollThread = null;
    resetScroll();

    setInterval(function(){
        $('#container').load('/update',{type:type, gare:gare},
            function (responseText, textStatus, XMLHttpRequest) {
                if (textStatus == "success") {
                    if(nbRows < $('#container').find('tr').length){
                        nbRows = $('#container').find('tr').length;
                        resetScroll();
                    }
                }
            });

    },1000);

});
