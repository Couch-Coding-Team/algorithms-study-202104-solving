/**
 * @param {string} digits
 * @return {string[]}
 */
var letterCombinations = function(digits) {
    
    if(digits === "") return [];
    
    let hash = {
        2: "abc",
        3: "def",
        4: "ghi",
        5: "jkl",
        6: "mno",
        7: "pqrs",
        8: "tuv",
        9: "wxyz"
    }
    let ans = [];
    let d = [];
    
    for(let i = 0; i < digits.length; i++){
        d.push(hash[digits[i]]);
    }
    function dfs(d, i, str){
        if(d.length <= i){
            ans.push(str);
            return;
        }
        for(let j = 0; j < d[i].length; j++){
            dfs(d, i+1, str + d[i][j])
        }
        
    }
    
    dfs(d, 0, "")
    
    return ans;
};
