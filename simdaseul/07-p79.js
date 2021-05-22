/**
 * @param {character[][]} board
 * @param {string} word
 * @return {boolean}
 */
var exist = function(board, word) {
    
    function search(board, word, searched, m, n, visited){
        if(searched === word){
            ans = true
            return
        }
        let sLen = searched.length
        let sChar = word[sLen];
        //console.log(visited)
        if(board?.[m-1]?.[n] ===  sChar && visited?.[m-1]?.[n] !== "1"){
            visited[m-1][n] = "1"
            search(board, word, searched+sChar, m-1, n, visited)
            visited[m-1][n] = "0"
        }
        if(board?.[m+1]?.[n] === sChar && visited?.[m+1]?.[n] !== "1"){
            visited[m+1][n] = "1"
            search(board, word, searched+sChar, m+1, n, visited)
            visited[m+1][n] = "0"
        }
        if(board?.[m]?.[n-1] === sChar && visited?.[m]?.[n-1] !== "1"){
            visited[m][n-1] = "1"
            search(board, word, searched+sChar, m, n-1, visited)
            visited[m][n-1] = "0"
        }
        if(board?.[m]?.[n+1] === sChar && visited?.[m]?.[n+1] !== "1"){  
            visited[m][n+1] = "1"
            search(board, word, searched+sChar, m, n+1, visited)
            visited[m][n+1] = "0"
        }
        
    }
    
    let ans = false
    
    let visited = new Array(board.length)
    for(let i = 0; i < board.length; i++){
        visited[i] = new Array(board[0].length).fill("0")
    }
    
    for(let m = 0; m < board.length; m++){
        for(let n = 0; n < board[m].length; n++){
            if(board[m][n] === word[0]){
                
                visited[m][n] = "1";                
                search(board, word, word[0] , m, n, visited)
                visited[m][n] = "0";
            }
        }
    }
        
    return ans
};
