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

    daysSpan.innerHTML = t.days;
    hoursSpan.innerHTML = ('0' + t.hours).slice(-2);
    minutesSpan.innerHTML = ('0' + t.minutes).slice(-2);
    secondsSpan.innerHTML = ('0' + t.seconds).slice(-2);

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

var deadlines = [newDeadline(3, 0, 0, 0), newDeadline(2, 0, 0, 0), newDeadline(1, 0, 0, 0),
				newDeadline(0, 1, 0, 0), newDeadline(0, 0, 30, 0), newDeadline(0, 0, 5, 0)];


for (var i = 0; i < 6; i++) {
	initializeClock(clocks[i], deadlines[i]);
}