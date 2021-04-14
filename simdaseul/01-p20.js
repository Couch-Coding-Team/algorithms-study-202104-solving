/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(s) {

    if(s.length % 2) return false; 
    
    let stack = [];
    let count = 0;
    
    for(let bracket of s){
        if(bracket === "(" || bracket === "[" || bracket === "{"){
            stack.push(bracket);
            ++count; 
        }else if(bracket === ")" || bracket === "]" || bracket === "}"){
            let pop = stack.pop();
            --count;
            if(pop === "(" && bracket === ")"){
                continue;
            }else if(pop === "[" && bracket === "]"){
                continue;
            }else if(pop === "{" && bracket === "}"){
                continue;
            }else{
                return false
            }
            
        }
    }
    
    if(count) return false;
    
    return true;
};
