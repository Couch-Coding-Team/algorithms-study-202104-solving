import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        Map<Integer,Double> failRatePerStage = new HashMap<>();
        int [] inCompletedPlayerCounts = new int[N+2];
        for(int i = 0; i < stages.length; i++) {
            int player = stages[i];
            inCompletedPlayerCounts[player]++;
        }
        
        int totalPlayer = stages.length;
        for(int i = 1; i < inCompletedPlayerCounts.length-1; i++) {
            double failRate = calculateFailRate(totalPlayer,inCompletedPlayerCounts[i]);
            totalPlayer -= inCompletedPlayerCounts[i];
            failRatePerStage.put(i,failRate);
        }
        
        return failRatePerStage.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) 	
            .map(Map.Entry::getKey)
            .mapToInt(i->i).toArray();

    }
    
    private double calculateFailRate(int totalPlayer, int inCompletedCount) {
        if(inCompletedCount == 0) {
            return (double) 0;
        }
        return ((double) inCompletedCount / (double) totalPlayer);
    }
}
