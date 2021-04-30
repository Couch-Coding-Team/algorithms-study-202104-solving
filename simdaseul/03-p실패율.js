function solution(N, stages) {
    var answer = [];
    let sortStages = [];
    let zeroStages = [];
    for(let i = 1; i <= N; i++){
        let stay = 0;
        let total = 0
        let fail = 0;
        for(let j = 0; j < stages.length; j++){
            if(stages[j] === i) stay++;
            if(stages[j] >= i) total++;
        }
        
        if(total === 0 || stay === 0){
            zeroStages.push(i);
        }else{
            fail = stay/total;
            sortStages.push([i, fail]);
        }
    }
    //console.log(sortStages, zeroStages)
    sortStages.sort((a,b)=> b[1] - a[1]);
    for(let i = 0; i < sortStages.length; i++){
        sortStages[i] = sortStages[i][0];
    }
    answer = [...sortStages, ...zeroStages];
    return answer;
}

// resTemp = [1,2,3,4,5] N 만큼
// 1 실패율 : 1/8
// 2 실패율 : 3/7
// 3 실패율 : 2/4
// 4 실패율 : 1/2
// 5 실패율 : 0/1
// 1 - [1], [2,3,4,5] 
// 2 - [2, 1], [3,4,5]
// 3 - [3,2,1], [4,5]
// 4 - [3,4,2,1], [5]
// 5 - [3,4,2,1], [5]
// 6 - [3,4,2,1,5]
