import java.util.*; 

class Solution {
        public long solution(int n, int[] times) {
            long answer = 0;

            Arrays.sort(times); // 심사 시간 정렬
            long left = 0;
            long right = times[times.length - 1] * (long) n; // 모든 사람이 가장 느리게 심사받는 경우

            while (left <= right) {
                long mid = (left + right) / 2;
                long finish = 0; // mid 시간 내에 처리 가능한 사람 수 계산

                // 각 심사관이 mid 시간 내에 몇명을 처리할 수 있는지 계산
                for (int i = 0; i < times.length; i++) {
                    finish += mid / times[i]; // mid 시간 동안 처리할 수 있는 사람 수 누적
                }
                    // mid 내에 처리할 수 있는 인원이 n보다 적으면 더 많은 시간을 줘야하므로 left 증가
                    if (finish < n) left = mid + 1;
                    else { // mid 내에 처리할 수 있는 인원이 n보다 많거나 같으면 더 적은 시간도 가능할 수 있으므로 right 감소
                        right = mid - 1;
                        answer = mid;
                    }
                }
            return answer;
        }
}