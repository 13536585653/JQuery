var N = 3;
var DRAW_BOUNDS = [50, 50, 500, 500];

var shudu;//数独对象
var currentPos;//当前位置
var canvas;//画布
var newCanvas;

function main(){
    shudu = new Shudu(N, visibleCount);
    canvas = document.getElementById("myCanvas");
    newCanvas = document.getElementById("new");
    canvas.addEventListener("click", selectGrid, true);
    window.addEventListener("keydown", insertNum, true);
    draw();
    rule = new Rule(shudu);
    rule.start();
}

//选择单元格
function selectGrid(event){
    var posX = event.pageX - canvas.offsetTop - 90;
    var posY = event.pageY - canvas.offsetLeft +100;

    //判断选中的位置
    var tmpPos = toPos(posX, posY);
    if(tmpPos == null)
		return;
    currentPos = shudu.visible(tmpPos[0], tmpPos[1])?currentPos:tmpPos;
    draw();
}

//填写数据
function insertNum(event){
    var numStart = 48;

    if(currentPos == null)
	return;

    if(event.keyCode > numStart && event.keyCode <= numStart + 9){
	var num = event.keyCode - numStart;
	shudu.insert(num, currentPos);
    }
    draw();
}

//判断是否在绘图区域内
function inDrawRange(x, y){
    if(x < DRAW_BOUNDS[0]|| y < DRAW_BOUNDS[1])
		return false;

    if(DRAW_BOUNDS[2] + DRAW_BOUNDS[0] <= x || DRAW_BOUNDS[3] + DRAW_BOUNDS[1] <= y)
		return false;

    return true;
}

//将坐标转换为位置
function toPos(x, y){
    if(!inDrawRange(x, y))
    	return currentPos;

    var CEIL_W = DRAW_BOUNDS[2]/(N*N);
    var CEIL_H = DRAW_BOUNDS[3]/(N*N);

    var posX = Math.floor((x - DRAW_BOUNDS[0]) / CEIL_W);
    var posY = Math.floor((y - DRAW_BOUNDS[1]-20) / CEIL_H);

    return [posX, posY];
}
