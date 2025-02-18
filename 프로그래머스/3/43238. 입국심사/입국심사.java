import java.util.*;
import java.io.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times);
        
        long min = 0;
        int num = times.length;
        
        // 모든 사람이 가장 느리게 심사
        long max = times[times.length - 1] * (long) n;
        
        while (min <= max) {
            long mid = (min + max) /2 ;
            long finish = 0; // mid 시간 내 처리 가능한 수
            
            for (int i=0; i<num; i++) {
                finish += mid / times[i]; // mid 시간 동안 처리할 수 있는 수 누적
            }
            
            if (finish < n) min = mid + 1;
            else {
                max = mid-1;
                answer = mid;
            }
        }
        return answer;
    }
}