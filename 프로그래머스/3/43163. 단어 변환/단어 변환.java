import java.util.*;

class Solution {
    static boolean[] visited;

    public int solution(String begin, String target, String[] words) {

        visited = new boolean[words.length]; 
        int answer = dfs(begin, target, words, 0);
        return answer == Integer.MAX_VALUE ? 0 : answer; 
    }

    static int dfs(String current, String target, String[] words, int cnt) {
        int minSteps = Integer.MAX_VALUE; // 최소 변환 횟수를 저장할 변수

        // 현재 단어가 target과 같다면 변환 횟수 반환
        if (current.equals(target)) {
            return cnt;
        }

        for (int i = 0; i < words.length; i++) {
            if (!visited[i]) { // 아직 방문하지 않은 단어만 탐색
                String word = words[i];
                int different = 0;

                // 현재 단어와 비교하여 다른 문자 개수 계산
                for (int j = 0; j < current.length(); j++) {
                    if (current.charAt(j) != word.charAt(j)) different++;
                }

                // 한 글자만 다르면 변환 가능
                if (different == 1) {
                    visited[i] = true; 
                    int steps = dfs(word, target, words, cnt + 1); // 재귀 호출
                    minSteps = Math.min(minSteps, steps); // 최소 변환 횟수 갱신
                    visited[i] = false; 
                }
            }
        }

        return minSteps; 
    }
}
