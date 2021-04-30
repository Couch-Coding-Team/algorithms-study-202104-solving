/**
 * @param {character[][]} grid
 * @return {number}
 */
var numIslands = function(grid) {
    function dfs(m, n){
        grid[m][n] = 0;        
        for(let i = 0; i < 4; i++){
            let newM = m + dm[i];
            let newN = n + dn[i];
            if(grid?.[newM]?.[newN] === '1' ){            
                dfs(newM,newN);
            }
        }
        

    }
    
    let cnt = 0;
    let dm = [-1,1,0,0];
    let dn = [0,0,-1,1];
    
    for(let m = 0; m < grid.length; m++){
        for(let n = 0; n < grid[m].length; n++){
            if(grid[m][n] === "1"){
                dfs(m, n);
                cnt++;
            }
        }
    }
    return cnt;
};
