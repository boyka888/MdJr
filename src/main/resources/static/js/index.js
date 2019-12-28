$(function(){
    $(".mobile_menu_button").click(function(){$(".mobile_menu").slideToggle(300);return false;});
    var maxMenu=0;
    $(".mobile_menu ul").each(function(){$(this).attr("rel","0");});
    $(".small_menu li").each(function(i){
        var menucount=parseInt($(this).parent().attr("rel"),10)+1;
        $(this).parent().attr("rel",menucount);
    });
    maxMenu=parseInt($(".small_menu > li").length,10);
    $(".mobile_menu").height((((maxMenu+1)*47)+maxMenu)+"px");
    var stime_menu;
    $(".small_menu li").each(function(){
        if($(this).find("ul").length>0){
            var thistext=$(this).find("a").eq(0).html();
            $(this).find("a").eq(0).html("<span class='text_box'>"+thistext+"</span><span class='arrow_box'>&gt;</span>");
        }else{
            var thistext=$(this).find("a").eq(0).html();
            $(this).find("a").eq(0).html("<span class='full_text_box'>"+thistext+"</span>");
        }
    });
    function GetWidth(){
        var maxwidth=$(window).width();
        $(".mobile_menu").css("width",maxwidth+"px");
        $(".mobile_menu .text_box").css("width",(maxwidth-90)+"px")
        stime_menu=setTimeout(function(){GetWidth();},10);
    }
    $(window).resize(function(){clearTimeout(stime_menu);GetWidth();});
    GetWidth();
    var menutag=1;
    $(".arrow_box").click(function(){
        var thishref=$(this).parent().attr("href");
        var thistext=$(this).parent().find(".text_box").eq(0).html();
        if(menutag==2){
            $(this).parent().parent().find("ul").eq(0).show();
            $(".subsub_menu_header").append("<a href='"+thishref+"' rel='"+$(this).parent().parent().parent().attr("rel")+"' class='title_link'>"+thistext+"</a>");
            $(".small_menu").animate({left:"-200%"},500);
            $(".menu_header_inner").animate({left:"-200%"},500);
            menutag=3;
        }
        if(menutag==1){
            $(this).parent().parent().find("ul").eq(0).show();
            $(".sub_menu_header").append("<a href='"+thishref+"' rel='"+$(this).parent().parent().parent().attr("rel")+"' class='title_link'>"+thistext+"</a>");
            $(".small_menu").animate({left:"-100%"},500);
            $(".menu_header_inner").animate({left:"-100%"},500);
            menutag=2;
        }
        var thish=$(this).parent().parent().find("ul").eq(0).height()+47;
        $(".mobile_menu").animate({height:thish+"px"},500);
        return false;
    });
    $(".back_arrow").click(function(){
        var thisn=parseInt($(this).parent().find(".title_link").eq(0).attr("rel"),10);
        var thish=(thisn+1)*47+thisn;
        $(".mobile_menu").animate({height:thish+"px"},500);
        if(menutag==2){
            var thisremove=$(this).parent().find(".title_link").eq(0);
            setTimeout(function(){thisremove.remove();$(".small_menu li ul").hide();},500);
            $(".small_menu").animate({left:"0px"},500);
            $(".menu_header_inner").animate({left:"0px"},500);
            menutag=1;
        }
        if(menutag==3){
            var thisremove=$(this).parent().find(".title_link");
            setTimeout(function(){thisremove.remove();$(".small_menu li ul ul").hide();},500);
            $(".small_menu").animate({left:"-100%"},500);
            $(".menu_header_inner").animate({left:"-100%"},500);
            menutag=2;
        }
        return false;
    });

    jQuery(".picScroll").slide({ mainCell:"ul",autoPlay:true,effect:"left", vis:11, scroll:1, autoPage:true, pnLoop:false,mouseOverStop:false});
    if(navigator.userAgent.match(/mobile/i)) {
        $('.float .span5').click(function() {
            $('.float .er').fadeToggle();
            return false;
        });
    }else{
        $('.float .span5').hover(function() {
            $('.float .er').fadeIn();
        }, function() {
            $('.float .er').fadeOut();
        });
        $('.float .divkf').hover(function() {
            $('.float .kf').fadeIn();
        }, function() {
            $('.float .kf').fadeOut();
        });
    }
    $('.float .gb').click(function(){
        if($(this).find('.span6').hasClass("span6")){
            $('.float').animate({'width':'50px'},300);
            $(".float .hiddle").slideUp('down');
            $('.float .div').animate({'height':'48px'},300);
            $(".float .span1").addClass("span11");
            $(".float .span6").addClass("span66");
            $(".float .span1").removeClass("span1");
            $(".float .span6").removeClass("span6");
            return false;
        }else{
            $('.float').animate({'width':'70px'},300);
            $(".float .hiddle").slideDown('fast');
            $('.float .div').animate({'height':'80px'},300);
            $('.float .gb').animate({'height':'55px'},300);
            $(".float .span11").addClass("span1");
            $(".float .span66").addClass("span6");
            $(".float .span11").removeClass("span11");
            $(".float .span66").removeClass("span66");
            return false;
        }
    });
    $(".goto").click(function(){
        $('body,html').animate({scrollTop:0},800);
            return false;
    });


});