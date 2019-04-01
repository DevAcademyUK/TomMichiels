function getTimeRemaining(endtime) {
  var t = Date.parse(endtime) - Date.parse(new Date());
  var seconds = Math.floor((t / 1000) % 60);
  var minutes = Math.floor((t / 1000 / 60) % 60);
  var hours = Math.floor((t / (1000 * 60 * 60)) % 24);
  var days = Math.floor(t / (1000 * 60 * 60 * 24));
  return {
    'total': t,
    'days': days,
    'hours': hours,
    'minutes': minutes,
    'seconds': seconds
  };
}

function initializeClock(id, endtime) {
  var clock = document.getElementById(id);

  var daysSpan = clock.querySelector('.days');
  var hoursSpan = clock.querySelector('.hours');
  var minutesSpan = clock.querySelector('.minutes');
  var secondsSpan = clock.querySelector('.seconds');


  function updateClock() {
    var t = getTimeRemaining(endtime);
    var dayLeft, hourLeft, minLeft, secLeft;
    
    dayLeft = t.days;
    hourLeft = ('0' + t.hours).slice(-2);
    minLeft = ('0' + t.minutes).slice(-2);
    secLeft = ('0' + t.seconds).slice(-2);

    if (dayLeft == "0") {
    	daysSpan.innerHTML = "";
    } else {
    	daysSpan.innerHTML = dayLeft + "d:";
    }
    
    if (hourLeft == "00" && dayLeft == "0") {
    	hoursSpan.innerHTML = "";
    } else {
    	hoursSpan.innerHTML = hourLeft + "h:";
    }

    if (minLeft == "00" && hourLeft == "00" && dayLeft == "0") {
    	minutesSpan.innerHTML = "";
    } else {
    	minutesSpan.innerHTML = minLeft + "m:";
    }

    if (secLeft == "00" && minLeft == "00" && hourLeft == "00" & dayLeft == "0") {
    	clock.innerHTML = "<strong>Deal Over<strong>";
    	clock.classList.add("deal-over");
    }
    secondsSpan.innerHTML = secLeft + "s";

    if (t.total <= 0) {
      clearInterval(timeinterval);
    }
  }

  updateClock();
  var timeinterval = setInterval(updateClock, 1000);
}

function newDeadline(days, hours, minutes, seconds) {

	var timeAdded = seconds * 1000;
	timeAdded += minutes * 60 * 1000;
	timeAdded += hours * 60 * 60 * 1000;
  	timeAdded += days * 24 * 60 * 60 * 1000;
	var deadline = new Date(Date.parse(new Date()) + timeAdded);

	return deadline;

}

var clocks = ['item1', 'item2', 'item3', 'item4', 'item5', 'item6'];

var deadlines = [newDeadline(256, 0, 0, 0), newDeadline(1, 0, 0, 30), newDeadline(1, 0, 0, 0),
				newDeadline(0, 1, 0, 30), newDeadline(0, 0, 1, 30), newDeadline(0, 0, 0, 30)];


for (var i = 0; i < 6; i++) {
	initializeClock(clocks[i], deadlines[i]);
}

$(".myBox").click(function() {
  window.location = $(this).find("a").attr("href"); 
  return false;
});

 $( ".card" ).hover(
  function() {
    $(this).addClass('shadow-lg').css('cursor', 'pointer'); 
  }, function() {
    $(this).removeClass('shadow-lg');
  }
);