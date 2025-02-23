import java.util.*;

class Solution {
        public boolean[] visited; public int answer;
    
        public int solution(int k, int[][] dungeons) {
            answer = -1;
            visited = new boolean[dungeons.length];
            dfs(0, k, dungeons);
            return answer;
        }

        public void dfs(int idx, int k, int[][] dungeons) {
            for (int i=0; i<dungeons.length; i++){
                if (!visited[i] && k >= dungeons[i][0]){ // 방문하지 않았고, 현재 피로도가 필요 피로도보다 높으면
                    visited[i] = true;
                    dfs(idx+1, k-dungeons[i][1], dungeons); // 재귀 -> 피로도 누적
                    visited[i] = false;
                }
            }
            answer = Math.max(answer, idx);
        }
    }