/**
 * 
 */
 
 $(function(){
	$("#email").keyup(function(){
		var in_email=$(this).val();
		//비동기통신
		$.ajax({
			url:"/member/emailCheck",
			data:{email:in_email},
			type:"post",
			success:function(result){
				if(result){
					$("#email").parent().siblings(".msg").text("사용불가").css("color","green");
				}
				
			}
		});
	});
	
	
});