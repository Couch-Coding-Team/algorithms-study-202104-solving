/**
 * @param {string} s
 * @return {string}
 */
var longestPalindrome = function(s) {
    
    let slen = s.length;
    let dp = [];
    let ans;
    let f = 0,
        b = 1;
    
    
    for(let i = 0; i < slen; i++){
        dp.push(new Array(slen));
    }
    
    for(let i = 0; i < slen; i++){
        dp[i][i] = true;
    }
    for(let i = 1; i < slen; i++){
        if(s[i-1] === s[i]){
            dp[i-1][i] = true;
            
        }
    }
    
    for(let l = 2; l < slen; l++){
        for(let i = 0; i < slen-l; i++){
            let j = l+i;
            if(s[i] === s[j] && dp[i+1][j-1] === true){
                dp[i][j] = true;
            }
            
        }
    }

    
    for(let i = 0; i < slen; i++){
        
        for(let j = slen-1; j >= i; j--){
            if(dp[i][j] === true && b-f-1 < j-i){
                
                f = i;
                b = j+1;
                break;
            }
        }
        
    }
    
    ans = s.slice(f, b); 
    
    return ans;
};
