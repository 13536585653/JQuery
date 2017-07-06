//数独类
function Shudu(n, visibleCount){
    this.n = n;
    this.size = n*n;
    this.count = (visibleCount <= this.size * this.size)?visibleCount:this.size * this.size;
    this.conflicts = new Array();//用于存储冲突的位置
    this.results = new Array();//用于存储游戏结果
    //产生内容
    this.generateContent();
}

//产生内容
Shudu.prototype.generateContent = function(){
    this.realMap = TwoDArray(this.size, this.size);
    this.mask = TwoDArray(this.size, this.size);

    for(var i=0;i<this.size;i++){
		for(var j=0;j<this.size;j++){
			//移除无效的数
			var candinates = this.generateCandinates();
			var relativeNums = this.getRelativeNums(i, j).nums;
			for(var k=0;k<candinates.length;k++){
			if(array_index(relativeNums, candinates[k]) != -1){
				array_delete(candinates, candinates[k]);
				k--;
			}
			}

			//填入数字
			if(candinates.length == 0){
			i--;
			continue;
			}
			this.realMap[i][j] = this.getCandinate(candinates);
		}
    }

    //产生掩码
    for(var i=0;i<this.count;i++){
		var x = Math.floor(Math.random() * this.size);
		var y = Math.floor(Math.random() * this.size);
		if(this.mask[x][y] != 0){
			i--;
			continue;
		}

		this.mask[x][y] = 1;
    }

    //清除不可视区
    for(var i=0;i<this.size;i++){
		for(var j=0;j<this.size;j++){
			if(this.mask[i][j] == 0){
				var result = new ShuduResult(this.realMap[i][j], i, j);
				this.results.push(result);
				this.realMap[i][j] = 0;
			}
		}
    }
}

//生成候选数数组
Shudu.prototype.generateCandinates = function(){
    var candinates = new Array();
    for(var i=0;i<this.size;i++){
		candinates.push(i+1);
    }

    return candinates;
}

//获取关联数字及其位置
Shudu.prototype.getRelativeNums = function(x, y){
    var relativeNums = new Array();
    var positions = new Array();

    //获取所有横向相关数字
    for(var i=0;i<this.size;i++){
		if(this.realMap[i][y] == 0 || i == x)
			continue;
		relativeNums.push(this.realMap[i][y]);
		positions.push([i, y]);
		//console.log("横向：%d", this.realMap[i][y]);
    }

    //获取所有纵向相关数字
    for(var i=0;i<this.size;i++){
		if(this.realMap[x][i] == 0 || i == y)
			continue;
		relativeNums.push(this.realMap[x][i]);
		positions.push([x, i]);
		//console.log("纵向：%d", this.realMap[x][i]);
    }

    //获取相同域中的相关数字
    var range = this.getRange(x, y);
    for(var i=range[0];i<range[1];i++){
		for(var j=range[2];j<range[3];j++){
			if(this.realMap[i][j] == 0 || (i == x && j == y))
				continue;
			relativeNums.push(this.realMap[i][j]);
			positions.push([i, j]);
			//console.log("域内：%d", this.realMap[i][j]);
		}
    }

    return {nums:relativeNums, positions: positions};
}

//获取候选数
Shudu.prototype.getCandinate = function(candinates){
    var index = Math.floor(Math.random() * candinates.length);
    return array_remove(candinates, index);
}

//获取宫格范围
Shudu.prototype.getRange = function(x, y){
    var range = [0, 0, 0, 0];

    var k = Math.ceil((x + 1)/this.n);
    range[0] = (k -1) * this.n;
    range[1] = k * this.n;
    k = Math.ceil((y + 1)/this.n);
    range[2] = (k - 1) * this.n;
    range[3] = k * this.n;

    return range;
}

//插入新数
Shudu.prototype.insert = function(num, pos){
    this.realMap[pos[0]][pos[1]] = num;
    this.findConflicts(num, pos);
}

//查找冲突
Shudu.prototype.findConflicts = function(num, pos){
    var relativeNums = this.getRelativeNums(pos[0], pos[1]);
    var nums = relativeNums.nums;
    var positions = relativeNums.positions;
    var conflict = new Conflict(pos[0], pos[1]);

    //查找冲突
    for(var i=0;i<nums.length;i++){
	if(num == nums[i]){
	    conflict.addPosition(positions[i][0], positions[i][1]);
	}
    }

    this.addConflict(conflict);
}

//添加冲突
Shudu.prototype.addConflict = function(conflict){
    var pos1 = conflict.getPos();

    //移除之前相同位置的冲突
    for(var i=0;i<this.conflicts.length;i++){
	var pos2 = this.conflicts[i].getPos();
	var positions = this.conflicts[i].getPositions();
	if(pos2[0] == pos1[0] && pos2[1] == pos1[1]){
	    array_remove(this.conflicts, i);
	    return;
	}
    }

    //添加新的冲突
    if(conflict.getPositions().length == 0)
	return;
    this.conflicts.push(conflict);
}

//获取冲突列表
Shudu.prototype.getConflicts = function(){
    return this.conflicts;
}

//判断是否可编辑
Shudu.prototype.visible = function(x, y){
    return this.mask[x][y];
}

//获取元素在数组中的索引位置
function array_index(array, elem){
    for(var i=0;i<array.length;i++){
	if(array[i] == elem)
	    return i;
    }

    return -1;
}

//从数组中移除元素
function array_remove(array, index){
    if(index >= 0 && index < array.length){
    	var result = array.splice(index, 1);
        return result[0];
    }
    
    return null;
}

//从数组中删除元素
function array_delete(array, elem){
    var index = array_index(array, elem);
    if(index != -1){
	array.splice(index, 1);
	return true;
    }

    return false;
}

//生成二维数组
function TwoDArray(width, height){
    array = new Array();
    for(var i=0;i<width;i++){
		var col = new Array();
		for(var j=0;j<height;j++){
			col.push(0);
		}
		array.push(col);
    }
    
    return array;
}

//冲突类
function Conflict(x, y){
    this.pos = [x,y];
    this.positions = new Array();
}

//添加冲突位置
Conflict.prototype.addPosition = function(x, y){
    this.positions.push([x,y]);
}

//获取产生冲突的位置
Conflict.prototype.getPos = function(){
    return this.pos;
}

//获取冲突位置列表
Conflict.prototype.getPositions = function(){
    return this.positions;
}

/****游戏结果类****/
function ShuduResult(num, x, y){
    this.num = num;
    this.pos = [x, y];
}