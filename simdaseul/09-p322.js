var coinChange = function(coins, amount) {
    const upperLimit = amount + 1;
	// create an array for caching the min coins for each price (<= price <= amount)
    const dp = Array(upperLimit).fill(upperLimit);
    dp[0] = 0;
    
	// starting from each coin, determine the min coins required to get amount sum
    coins.forEach(coin => {
        for(let idx = coin; idx < upperLimit; ++idx) {
            dp[idx] = Math.min(dp[idx], dp[idx - coin] + 1);
        }
    })
    return dp[amount] === upperLimit ? -1 : dp[amount];
};
