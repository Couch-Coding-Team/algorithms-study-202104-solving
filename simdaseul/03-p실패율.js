function moveBracket(board, moves){
    let m = board[0].length;
    let n = board.length;
    let pos = new Array(m).fill(0);
    let bracket = [];
    
    for(let i = 0; i < m; i++){
        for(let j = 0; j < n; j++){
            if(board[j][i]){
                pos[i] = j; // j = 위치
                break;
            }
        }
    }
    //console.log(pos)
    for(let i = 0; i < moves.length; i++){
        let w = moves[i] - 1;// 가로
        let h = pos[w];// 세로
        if(h >= n) continue;
        if(board[h][w]){
            bracket.push(board[h][w]);
            pos[w]++
        }
    }
    //console.log(bracket);
    return bracket
}
function crash(bracket){
    for(let i = 0; i < bracket.length-1; i++){
        if(bracket[i] === bracket[i+1]){
            let newBracket = [...bracket.slice(0,i), ...bracket.slice(i+2)];
            return crash(newBracket) + 2;
        }
    }   
    return 0;
}

function solution(board, moves) {
    var answer = 0;
    let bracket = moveBracket(board, moves);
    answer = crash(bracket)
    return answer;
}

// 0 0 0 0 0
// 0 0 1 0 3
// 0 2 5 0 1
// 4 2 4 4 2
// 3 5 1 3 1
// move : [1,5,3,5,1,2,1,4]
// stack : [4, 3, 1, 1, 3, 2, 4]
// crashStack : [4, 2, 4] 
