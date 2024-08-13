import java.util.*;

class Solution {
        public int solution(int[][] routes) {
            // 경로의 끝 지점을 기준으로 오름차순 정렬
            Arrays.sort(routes, (r1, r2) -> Integer.compare(r1[1], r2[1]));

            int answer = 0;
            int camera = Integer.MIN_VALUE; // 현재 설치된 카메라의 위치를 초기화

            for (int[] route : routes) {
                // 현재 설치된 카메라가 커버하지 못하는 경우
                if (camera < route[0]) {
                    camera = route[1]; // 새로운 카메라 설치
                    answer++; // 카메라 설치 횟수 증가
                }
            }

            return answer;
        }
    }