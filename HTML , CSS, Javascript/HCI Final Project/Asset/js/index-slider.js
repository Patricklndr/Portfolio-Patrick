$(document).ready(function(){
    $('.next').on('click', function(){
        var currentImg = $('.active');
        var nextImg = currentImg.next();

        if(nextImg.length){
            currentImg.removeClass('active').css('opacity', 0);
            nextImg.addClass('active');
            $('.active').animate({
               opacity: "1"
            }, 1000);
        }
    });

    $('.prev').on('click', function(){
        var currentImg = $('.active');
        var prevImg = currentImg.prev();
         if(prevImg.length){
            currentImg.removeClass('active').css('opacity', 0);
            prevImg.addClass('active');
            $('.active').animate({
               opacity: "1"
            }, 1000);
        }
    });
});