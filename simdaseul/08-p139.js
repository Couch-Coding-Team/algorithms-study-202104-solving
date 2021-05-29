/**
 * @param {string} s
 * @param {string[]} wordDict
 * @return {boolean}
 */


var wordBreak = function(s, wordDict) {
    var memo = {};
    

    function wb(s, wordDict){
        if(s in memo) return memo[s];
    
        let answer = false;

        for(let i = 0; i < wordDict.length; i++){
            let len = wordDict[i].length;

            if(wordDict[i] === s.substr(0, len)){

                if(len === s.length) answer = true;
                else answer |= wb(s.substr(len), wordDict);
            }

            if(answer) break;
        }

        memo[s] = answer;
        return answer;
    }
    
    return wb(s, wordDict);
    
};
