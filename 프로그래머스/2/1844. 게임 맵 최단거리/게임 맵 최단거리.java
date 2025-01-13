import java.util.*;

class Solution {

        static int[] di = new int[] {-1, 0, 0, 1};
        static int[] dj = new int[] {0, 1, -1, 0};
        static boolean[][] v;
        static int m, n;

        public int solution(int[][] maps) {
            int answer = 0;
            m = maps.length;
            n = maps[0].length;

            v = new boolean[m][n];

            answer = bfs(maps, 0, 0);

            return answer;
        }

        public int bfs(int[][] maps, int row, int col) {
            ArrayDeque<int[]> q = new ArrayDeque<>();
            q.offer(new int[] {row,col,1});
            v[row][col] = true;

            while (!q.isEmpty()) {
                int[] current = q.poll();
                int distance = current[2];

                if (current[0] == m-1 && current[1] == n-1) {
                    return distance;
                }

                for (int d=0; d<4; d++) {
                    int ii = current[0] + di[d];
                    int jj = current[1] + dj[d];

                    if (ii >= 0 && ii < m && jj >= 0 && jj < n &&maps[ii][jj] == 1 && !v[ii][jj]) {
                        q.offer(new int[] {ii,jj, distance+1});
                        v[ii][jj] = true;
                    }
                }
            }
            return -1;
        }
    }

