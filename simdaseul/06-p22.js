var generateParenthesis = function (n) {
    let ans = [];
    if( n == 0){
        ans.push("");
    }else {
        for(let i = 0; i < n; i++){
            for(let left of generateParenthesis(i)){
                for(let right of generateParenthesis(n-1-i)){
                    ans.push("(" + left +")" + right);
                }
            }
        }
    }
	return ans
}
