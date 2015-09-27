Array.prototype.in_array = function(e){  
	for(i=0;i<this.length && this[i]!=e;i++);  
	return !(i==this.length);  
}  
Array.prototype.indexOf = function(val) {
    for (var i = 0; i < this.length; i++) {
        if (this[i] == val) return i;
    }
    return -1;
};
Array.prototype.remove = function(val) {
    var index = this.indexOf(val);
    if (index > -1) {
        this.splice(index, 1);
    }
};