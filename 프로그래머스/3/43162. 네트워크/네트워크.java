import java.util.*;

class Solution {
        public int solution(int n, int[][] computers) {
            int answer = 0;

            boolean[] v = new boolean[n];


            for (int i=0; i<n; i++) {
                if (!v[i]) {
                    bfs(i, n, computers, v);
                    answer ++;
                }
            }
            return answer;
        }

        public void bfs(int start, int n, int[][] computers, boolean[] v) {
            ArrayDeque<Integer> q = new ArrayDeque<>();
            q.offer(start);
            v[start] = true;

            while (!q.isEmpty()) {
                int current = q.poll();

                for (int i=0; i<n; i++) {
                    if (computers[current][i] == 1 && !v[i]) {
                        v[i] = true;
                        q.offer(i);
                    }
                }
            }
        }
    }
