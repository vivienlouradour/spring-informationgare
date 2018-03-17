function slider() {
	
    var startTime = +new Date();
    $('#resultsList').css('overflow', 'hidden');
    
    var slider = $('#trainsList'),
        items = slider.find('tr');
    
    var sliderHeight = slider.height(),
        itemsNum = items.length,
        itemHeight = items.height();

    slider.css('top', '-' + (sliderHeight + itemHeight) + 'px');

    var startPos = slider.css('top');

    items.first().before(items.clone());
    items.last().after(items.clone());

    scrollItems(slider,sliderHeight,itemHeight,startPos,4);
    var endTime = +new Date();
    var diff = endTime - startTime;
    setInterval(function(){ 
        scrollItems(slider,sliderHeight,itemHeight,startPos,4);
    }, 7000);
}

function scrollItems(container, targetsHeight, increment, startPos, time) {
	
    var secs = time * 1000;
    container.animate({
        'top': '-' + ((targetsHeight * 2) + increment) + 'px'
    }, secs, 'linear', function () {
        container.css('top', startPos);
    });
}
