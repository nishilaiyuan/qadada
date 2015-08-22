/* 
* @Author: anchen
* @Date:   2015-08-22 20:00:10
* @Last Modified by:   anchen
* @Last Modified time: 2015-08-22 20:00:27
*/

$(function(){   
    //顶部导航切换
    $(".nav li a").click(function(){
        $(".nav li a.selected").removeClass("selected")
        $(this).addClass("selected");
    }) 

    $(function(){   
    //导航切换
    $(".menuson li").click(function(){
        $(".menuson li.active").removeClass("active")
        $(this).addClass("active");
    });
    
    $('.title').click(function(){
        var $ul = $(this).next('ul');
        $('dd').find('ul').slideUp();
        if($ul.is(':visible')){
            $(this).next('ul').slideUp();
        }else{
            $(this).next('ul').slideDown();
        }
    });
})   
}) 

 /**设置iframe的高度**/
    $(function(){
        setWidowWH();
    })
    $(window).resize(function(){
     setWidowWH();
    });
    function setWidowWH(){
        var bodyHeight = $(document).height();
        var windosWidth = $(window).width();
        var windosHeight = $(window).height();
        $('#content').attr("height",bodyHeight);
        $('.left').css("width",'187px');
        $('.right').css("width",windosWidth-204);
    } 