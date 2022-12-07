function getTime(dealine) {
    const dealineDate = new Date(dealine);
    const now = new Date();
    /// khoang cách giữa 2 ngày 
    const distant = (dealineDate - now) / 1000 //giay

    // days
    const days = Math.floor(distant / 3600 / 24);
    // hours
    const hours = Math.floor(distant / 3600) % 24
        /// minutes
    const minites = Math.floor(distant / 60) % 60
        // seconds
    const seconds = Math.floor(distant) % 60;

    //render html
    $(".time-days").text(days);
    $(".time-hours").text(hours);
    $(".time-mins").text(minites);
    $(".time-secs").text(seconds);

}

setInterval(() => {
    getTime("2022/12/30")
}, 1000);

// totop

$(window).scroll(function() {
    //lấy kích thước hiện tại 
    const current = $(this).scrollTop();

    if (current > 200) {
        $(".totop").addClass("fixed");
    } else {
        $(".totop").removeClass("fixed");
    }
});

// click 
$(".totop").click(function(e) {
    e.preventDefault();
    $("body,html").animate({
        scrollTop: 0,
    })
});