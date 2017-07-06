var script=document.createElement("script");
script.type="text/javascript";
script.src="/Shudum/js/jquery-3.0.0.js";
document.getElementsByTagName('head')[0].appendChild(script);
	
	document.addEventListener("visibilitychange", function () {
    if (document.hidden) {
       $("title").text("(′・ω・`)等你回来");
    } else  {
      $("title").text("数独");
    }
}, false);
