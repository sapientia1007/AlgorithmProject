import java.util.*;

class Solution {
        static int[][] g;
        public int solution(int n, int[][] wires) {
            int answer = -1;
            g = new int[n+1][n+1];

            for (int i=0; i<wires.length; i++) {
                int n1 = wires[i][0]; int n2 = wires[i][1];
                g[n1][n2] = 1; g[n2][n1] = 1; // 양방향 - 인접행렬 input
            }
            // 각 간선을 끊어서 분리된 두 부분의 차이를 계산
            for (int i=0; i<wires.length; i++) {
                int n1 = wires[i][0]; int n2 = wires[i][1];
                g[n1][n2] = 0; g[n2][n1] = 0; // 선 끊기

                // 분리된 두 부분의 크기를 계산
                int cnt1 = bfs(n, n1); // n1을 시작으로 하는 부분의 크기
                int cnt2 = n - cnt1;   // 나머지 부분의 크기

                // 두 부분의 크기 차이를 계산하고, 최소값 찾기
                if (answer == -1 || Math.abs(cnt1 - cnt2) < answer) {
                    answer = Math.abs(cnt1 - cnt2);
                }
                g[n1][n2] = 1; g[n2][n1] = 1; // 선 복구

            }
            return answer;
        }

        // bfs를 사용하여 주어진 노드와 연결된 모든 노드를 찾는 함수
        public static int bfs(int n, int n1) {
            boolean[] v = new boolean[n+1];
            int cnt = 0;
            ArrayDeque<Integer> q = new ArrayDeque<>();
            v[n1] = true;
            q.offer(n1);

            while (!q.isEmpty()){
                int tmp = q.poll();
                cnt++;

                // 인접 노드를 순회
                for (int i=1; i<=n; i++){
                    if (g[tmp][i] == 1 && !v[i]){
                        v[i] = true;
                        q.offer(i);

                    }
                }
            }
            return cnt ; // 현재 연결된 노드의 수 반환
        }
    }