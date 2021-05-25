/**
 * @param {number[]} height
 * @return {number}
 */
var trap = function(height) {
    let ans = 0;
    
    let maxI;
    let maxV = 0;
    
    for(let i = 0; i < height.length; i++){
        if(maxV <= height[i]){
            maxI = i;
            maxV = height[i];
        }
    }
    
    let left = 0; 
    let right = height.length - 1
    
    let lCurMax = 0;
    for(let i = left; i < maxI; i++){
        if(lCurMax > height[i]){
            ans += lCurMax - height[i];
        }else{
            lCurMax = height[i];
        }
    }
    
    let rCurMax = 0;
    for(let i = right; i > maxI; i--){
        if(rCurMax > height[i]){
            ans += rCurMax - height[i];
        }else{
            rCurMax = height[i];
        }
    }
        
    return ans; 
};
