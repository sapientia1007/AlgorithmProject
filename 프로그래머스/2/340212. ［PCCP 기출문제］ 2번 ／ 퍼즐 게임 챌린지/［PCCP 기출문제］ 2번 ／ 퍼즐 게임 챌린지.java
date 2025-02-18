import java.util.*;
import java.io.*;

// 난이도(diff)가 숙련도(level)를 초과하면 추가 시간이 발생 => (난이도 - 숙련도) * (이전 퍼즐 소요시간 + 현재 퍼즐 소요시간)
class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;        
        long min = 1;
        long max = limit;
        int n = times.length;
        
        while (min < max) {
            long mid = (min+max) / 2; // 현재 level
            long t = (long) times[0]; // 첫 번째 퍼즐 소요시간 
            
            for (int i=1; i<n; i++) {
                if (diffs[i] > mid) { // 난이도가 level 초과하면 추가 시간 발생
                    t += ((long) diffs[i] - mid) * ((long) times[i-1] + (long) times[i]);
                }
            t += (long) times[i]; 
            }
            
            if (limit < t) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        answer = (int) min;
        return answer;
    }
}