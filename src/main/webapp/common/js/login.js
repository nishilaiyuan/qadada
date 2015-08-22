
// Cloud Float...
    var $main = $cloud = mainwidth = null;
    var offset1 = 450;
	var offset2 = 0;
	
	var offsetbg = 0;
    
    $(document).ready(
        function () {
            $main = $("#mainBody");
			$body = $("body");
            $cloud1 = $("#cloud1");
			$cloud2 = $("#cloud2");
			
            mainwidth = $main.outerWidth();
         
        }
    );

    /// 飘动
    setInterval(function flutter() {
        if (offset1 >= mainwidth) {
            offset1 =  -580;
        }

        if (offset2 >= mainwidth) {
			 offset2 =  -580;
        }
		
        offset1 += 1.1;
		offset2 += 1;
        $cloud1.css("background-position", offset1 + "px 100px")
		
		$cloud2.css("background-position", offset2 + "px 460px")
    }, 70);
	
	
	setInterval(function bg() {
        if (offsetbg >= mainwidth) {
            offsetbg =  -580;
        }

        offsetbg += 0.9;
        $body.css("background-position", -offsetbg + "px 0")
    }, 90 );
	
	$(function(){
	   $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	   $(window).resize(function(){  
	   $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	   })  
	}); 
	
	function checkUserForm() {
		alert("xxx");
		var userName = $("#username").val();
		var userPassword = $("#password").val();
		if (userName == "" || userPassword == "") {
			alert("用户名或密码不能为空");
			return false;
		}
		var b;
		$.ajax({
					type : "POST",
					url : "qadada/loginCheck.html?data="+ new Date(),
					data : {
						username : userName,
						password : userPassword
					},
					dataType: "json",
					async : false,
					success : function(data) {
						if (data.error == "0") {
							b = false;
						} else {
							b = true;
							alert(data.error);
						}
					}
				});
		if (b) {
			return true;
		}
		document.loginForm.submit();
	}