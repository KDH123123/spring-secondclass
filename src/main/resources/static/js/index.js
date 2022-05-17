/**
 * 인덱스페이지의 js적용
 */
//ready//////////////////////////
/*브라우저가 로딩되면 자동으로 실행*/
$(function(){
	//console.log(timeData);
	/*ajax를 이용해서 서버에 접속해서 DB데이터를 JSON갖고옵니다.*/
	//*
	//console.log(gList.list);
	$.ajax({
		url: "goods/time",//요청,
		success:function(result){
			$("#time>.wrap").html(result);
			//html()실행하면 time-list 태그가 삽입됩니다.
			// .btn-wrap .next 태그가 존재하는 영역에서 등록이 되야합니다.
			CountDownTimer('05/28/2022 00:00:00', '.timeDeal'); 
		}
	});
	
	$.ajax({
		url: "goods/glist",
		/*result에는 list.jsp의 태그정보가 입력됩니다.*/
		success: function(result){
			$(".disp").html(result);
		}
	});
	
	/*$.get("goods/glist",function(){});*/
	
	//*/
	
});
////////////////////////////



function CountDownTimer(dt, className) {
     var end = new Date(dt);
     var _second = 1000;
     var _minute = _second * 60;
     var _hour = _minute * 60;
     var _day = _hour * 24;
     var timer;
     function showRemaining() {
         var now = new Date();
         var distance = end - now;
         if (distance < 0) {
             clearInterval(timer);
             $(className).html('타임딜 종료됨');
             return;
         }
         var days = Math.floor(distance / _day);
         var hours = Math.floor((distance % _day) / _hour);
         var minutes = Math.floor((distance % _hour) / _minute);
         var seconds = Math.floor((distance % _minute) / _second);
         var text = days + '일 ';
         text +=hours + '시간 ';
         text +=minutes + '분 ';
         text +=seconds + '초';
         $(className).html(text);
     }
     timer = setInterval(showRemaining, 1000);
 }
 