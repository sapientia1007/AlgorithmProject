class Solution {
        public int solution(String name) {
            int answer = 0;

            // 기본적으로 왼쪽 -> 오른쪽으로 가는걸 기본
            int minMove = name.length()-1;

            for (int i=0; i<name.length(); i++){
                char targetChar = name.charAt(i);
                int move = Math.min(targetChar-'A', 'Z'-targetChar+1);
                answer += move;

                int next = i+1;

                while (next < name.length() && name.charAt(next) == 'A') next++;       // 다음 A가 아닌 문자의 위치 찾기

                // 현재 위치에서의 이동 vs 되돌아오는 경로 비교
                minMove = Math.min(minMove, i+name.length()-next+Math.min(i, name.length()-next));
            }
            answer += minMove;
            return answer;
        }
    }