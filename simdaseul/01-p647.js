/**
 * @param {string} s
 * @return {number}
 */
var countSubstrings = function(s) { 
    
    let sum = 0;
    
    for(let i = 0; i < s.length; i++){
        for(let j = 1 + i; j <= s.length; j++){
            
            let subs = s.slice(i,j);
            
            let isPal = true;
            for(let k = 0; k < Math.round(subs.length/2); k++){
                
                if(subs[k] !== subs[subs.length - k - 1]){
                    isPal = false;
                    break;
                }
            }
            if(isPal){
                sum++;
            }
           
        }
    }
    return sum;
    
};
