import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int[] cores) {
        int answer = 0;
        int len = cores.length;

        // 만약 작업 수가 코어 수 이하라면 바로 반환
        if (n <= len) return n;

        int low = 1;
        int high = 10000 * n;
        int time = 0;
        int work = 0; // 작업량

        // 최소 시간(time)을 구하기 위한 이진 탐색
        while (low <= high) {
            int mid = (low + high) / 2;

            // mid 시간 동안 처리 가능한 작업량 계산
            int count = len; // 0초에 모든 코어가 한 번씩 처리
            for (int i = 0; i < len; i++) {
                count += mid / cores[i];
            }

            if (count >= n) {
                high = mid - 1;
                time = mid;
                work = count;
            } else {
                low = mid + 1;
            }
        }

        // 남은 작업량 계산
        work -= n;
        for (int i = len - 1; i >= 0; i--) {
            if (time % cores[i] == 0) { // 현재 시간이 해당 코어에서 작업이 끝나는 시점인지 확인
                if (work == 0) {
                    answer = i + 1; // 코어 번호는 1부터 시작하므로 +1
                    break;
                }
                work--;
            }
        }

        return answer;
    }
}
