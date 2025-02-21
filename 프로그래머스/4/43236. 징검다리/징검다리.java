import java.io.*;
import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks); 
        
        int left = 1, right = distance;  
        
        while (left <= right) {
            int mid = (left + right) / 2; 
            int rockCnt = 0;  // 제거한 돌의 개수
            int prevRockPosition = 0;  // 마지막으로 지나간 돌의 위치
            
            // 돌들을 확인하며 최소 거리를 유지할 수 없는 돌을 제거
            for (int i = 0; i < rocks.length; i++) {
                if (rocks[i] - prevRockPosition < mid) {  // 최소 거리보다 좁으면 돌을 제거
                    rockCnt++;
                } else {
                    prevRockPosition = rocks[i];  // 최소 거리 이상이면 지나감
                }
            }
            
            // 마지막 구간에서 최소 거리가 부족하면 돌 제거
            if (distance - prevRockPosition < mid) {
                rockCnt++;
            }
            
            // 제거한 돌이 n개 이하일 경우, 더 큰 최소 거리를 시도
            if (rockCnt <= n) {
                answer = mid;  // 가능한 최소 거리 갱신
                left = mid + 1;  
            } else {
                right = mid - 1;  
            }
        }
        
        return answer;  
    }
}
