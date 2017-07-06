var script=document.createElement("script");
script.type="text/javascript";
script.src="/Shudum/js/jquery-3.0.0.js";
document.getElementsByTagName('head')[0].appendChild(script);
	
	$(function() {
		$(".game").hover(function() {
			$(".game_all").show();
		}, function() {
			$(".game_all").hide();
		});
	})