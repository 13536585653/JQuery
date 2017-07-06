/****检测游戏结果****/
var numm = 0;
function Rule(shudu){
    this.shudu = shudu;
    this.timer = null;
    this.running = false;
}

Rule.prototype.start = function(){
    this.running = true;
    this.timer = setInterval(this.run, 200);
}

Rule.prototype.run = function(){
    if(this.running == false)
	return;
    var results = this.shudu.results;
    for(var i=0;i<results.length;i++){
		var posX = results[i].pos[0];
		var posY = results[i].pos[1];
	
		if(this.shudu.realMap[posX][posY] != results[i].num){
		    return;
		}
    }
    numm = 1;
    alert("恭喜你，顺利过关！");
    
    
   this.running = false;
    clearInterval(this.timer);
 }