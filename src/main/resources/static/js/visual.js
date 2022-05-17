/**
 * 작성자 : 나야나
 */
const imgUrls = [
	"url('/images/visual/img_1.gif')",
	"url('/images/visual/img_2.gif')",
	"url('/images/visual/img_3.jpg')",
	"url('/images/visual/img_4.jpg')",
	"url('/images/visual/img_5.jpg')",
	"url('/images/visual/img_6.jpg')",
	"url('/images/visual/img_7.jpg')",
	"url('/images/visual/img_8.jpg')",
	"url('/images/visual/img_9.gif')",
	"url('/images/visual/img_10.gif')",
	"url('/images/visual/img_11.gif')",
	"url('/images/visual/img_12.gif')",
	"url('/images/visual/img_13.gif')",
	"url('/images/visual/img_14.gif')",
	"url('/images/visual/img_15.jpg')",
	"url('/images/visual/img_16.gif')",
	"url('/images/visual/img_17.jpg')",
	"url('/images/visual/img_18.jpg')"
];
var size=415;
var delay=3000;
var speed=300;
var timeout;
var flag=0;

function imgLoading(){
	var lis=$(".imgs li");
	for(var i=0; i<imgUrls.length; i++){
		lis.eq(i).find("a").css("background-image",imgUrls[i]);
	}
	//블릿이미지에 첫번째꺼 디자인
	$(".bullet li").eq(0).addClass("target");
}
/////////////////////////////////

$(function(){
	imgLoading();
	
	//처음시작은 
	delayStart();
	//브라우져가 visibilityState 가 변경될때 실행되는 이벤트
	document.addEventListener("visibilitychange", function() {
		var state=document.visibilityState;
		console.log(state);
		if(state=="hidden"){
			stop();
		}else if(state=="visible"){
			delayStart();
		}
	});

	//setInterval(next, 2000);
	//hover이벤트 등록
	$(".imgs, #visual .btn").hover(stop,delayStart);
	//클릭이벤트 등록
	$("#visual .next").click(nextClicked);
	//클릭이벤트 등록
	$("#visual .prev").click(prevClicked);
	//블릿을 클릭했을때 이벤트 등록
	$(".bullet li").click(bulletClicked);
	
});

function bulletClicked(){
	//클릭한 블릿의 인덱스번호
	var idx=$(this).index();
	//블릿의 인덱스랑 이미지들의 value랑 일치
	var lis=$(".imgs li");
	var pos;
	for(var i=0; i<lis.length ; i++){
		var v=lis.eq(i).val();
		if(v==idx){
			//이동시킬 이미지 
			//이미지의 위치는? i 가 이미지 위치정보입니다.
			pos=i;
			break;
		}
	}//end for
	//이미지 이동
	move(pos);
	
	//블릿들 선택자
	var blis=$(".bullet li");
	//블릿들에 적용된 target 클래스 제거
	blis.removeClass("target");
	blis.eq(idx).addClass("target");
}
function move(_pos){//_pos=pos
	//alert(_pos);
	var imgs=$(".imgs");
	//매번 첫번째랑 마지막꺼가 바뀌므로 새로 선택해야합니다.
	for(var i=0; i<_pos; i++){
		var first=$(".imgs li:first-child");
		var last=$(".imgs li:last-child");
		imgs.css("left",-size);
		last.after(first);
		imgs.css("left",0);
	}
	
}

function nextClicked(){
	//중복 적용되지 않도록..
	if(flag==0)next();
}
function prevClicked(){
	//중복 적용되지 않도록..
	if(flag==0)prev();
}
//////////////////////////////////////////////////
function delayStart(){
	timeout=setTimeout(autoPlay, delay);
}
function autoPlay(){
	console.log("timeout 시작");
	next();
	//stop();
	timeout=setTimeout(autoPlay, delay);
}
function stop(){
	clearTimeout(timeout);
	console.log("timeout 해제");
}

//다음이미지를 왼쪽으로 이동: 호출시 1번만 실행
function next(){
	flag=1;
	var imgs=$(".imgs");
	var first=$(".imgs li:first-child");
	var last=$(".imgs li:last-child");
	//블릿들 선택자
	var blis=$(".bullet li");
	//블릿들에 적용된 target 클래스 제거
	blis.removeClass("target");
	imgs.animate({left: -size},speed,function(){
		//애니메이트가 실행후에 처리하는 구간..
		//첫번째 이미지를 제일뒤로 이동
		last.after(first);
		//앞에 이미지가 뒤로 이동했기때문에 다시 0으로
		imgs.css("left",0);
		
		//이동된 이미지의 value를 읽어들임
		var li_fv=$(".imgs li:first").val();//2
		//이미지의 순서와 일치하는 블릿에 target클래스 이름을 부여함.
		blis.eq(li_fv % blis.length).addClass("target");
		//target에 적용된 디자인이 이동하는 효과가 적용됨.
		
		flag=0;
	});
}

function prev(){
	flag=1;
	//블릿들 선택자
	var blis=$(".bullet li");
	//블릿들에 적용된 target 클래스 제거
	blis.removeClass("target");
	var imgs=$(".imgs");
	var first=$(".imgs li:first-child");
	var last=$(".imgs li:last-child");
	//이동전에 마지막 이미지를 앞으로 이동시키자..
	//숨어있는 공간에서 이동된다.
	first.before(last);
	imgs.css("left", -size);
	//왼->오 이동
	imgs.animate({left: 0},speed,function(){
		//애니메이트가 실행후에 처리하는 구간..
		//이동된 이미지의 value를 읽어들임
		var li_fv=$(".imgs li").eq(0).val();//2
		//이미지의 순서와 일치하는 블릿에 target클래스 이름을 부여함.
		blis.eq(li_fv % blis.length).addClass("target");
		
		
		flag=0;
	});
}
