import java.util.*;

class Solution {
        public int solution(int[] citations) {
            int answer = 0;

            // 배열 정렬
            Arrays.sort(citations);

            int n = citations.length;

            // 각 논문에 대해 h 계산
            for (int i=0; i<n; i++) {
                int h = n-i; // 현재 논문에서의 h 후보

                if (citations[i] >= h) { // 현재 인용 횟수가 h 이상인지 확인 -> 맞다면 h-index 업데이트
                    answer = h;
                    break;
                }
            }
            return answer;
        }
    }