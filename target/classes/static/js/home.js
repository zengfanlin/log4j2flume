var start = new Date();  
var strStart = start.getFullYear()+"-"+(start.getMonth()+1)+"-"+start.getDate()+" "+  
                start.getHours()+":"+start.getMinutes()+":"+start.getSeconds();  
var len = 0;  
var end;  
var status = "in";  
var second = 30;  
function revive(){  
    if(status == "out"){  
        start = new Date();  
        status = "in";  
    }  
    second = 30;  
}  
window.setInterval(function(){  
    second -= 1;  
    if(0 == second){  
        end = new Date();  
        len += (end.getTime() - start.getTime())/1000;  
        status = "out";  
    }  
},1000);  
$(‘body‘).click(function(){  
    revive();  
});  
$(‘body‘).mousedown(function(){  
    revive();  
});  
$(‘body‘).mouseup(function(){  
    revive();  
});  
$(‘body‘).mousemove(function(){  
    revive();  
});  
// (Firefox)
$(‘body‘).bind(‘DOMMouseScroll‘, function() {  
    revive();  
});  
// (IE,Google)
$(‘body‘).bind(‘mousewheel‘,function(){  
    revive();  
});  
$(‘body‘).keydown(function(e){  
    revive();  
});   
$(‘body‘).keyup(function(e){  
    revive();  
});   
$(‘body‘).keypress(function(e){  
    revive();  
});   
window.onbeforeunload = function(){  
   end = new Date();  
   var strEnd = end.getFullYear()+"-"+(end.getMonth()+1)+"-"+end.getDate()+" "+  
                end.getHours()+":"+end.getMinutes()+":"+end.getSeconds();  
   len += (end.getTime() - start.getTime())/1000;   
   var img = new Image();  
   img.src = contextPath + "behavior?stayTime=" + len + "&strStart" + strStart + "&lastDate=" + strEnd;  
};  