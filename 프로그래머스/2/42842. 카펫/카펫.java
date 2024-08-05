 class Solution {
        public int[] solution(int brown, int yellow) {
            int[] answer = new int[2];
            // 전체 사각형 개수
            int sum = brown+yellow;

            for (int i=3; i<=sum; i++) {
                if (sum % i == 0){ // 현재 길이가 전체 사각형 개수의 약수인 경우
                    int x = i;
                    int y = sum / i;
                    if ((x-2) * (y-2) == yellow) {
                        answer[0] = x; answer[1] = y; // 노란색 타일의 개수는 (가로 길이 - 2) * (세로 길이 - 2)로 계산
                    }
                }
            }
            return answer;
        }
    }