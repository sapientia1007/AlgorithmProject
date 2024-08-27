import java.util.*;

class Solution {
        // 0 : 벽이 있는 자리 <-> 1: 벽이 없는 자리(이동 가능한 자리)
        static int[] di = {-1,0,1,0};
        static int[] dj = {0,1,0,-1};
        static boolean[][] v ;
        static int row; static int col;
        public int solution(int[][] maps) {
            int answer = 0;

            row = maps.length; col = maps[0].length;

            v = new boolean[row][col]; // 방문 여부

            answer = bfs(maps,0, 0); // 시작점

            return answer;
        }
        public int bfs(int[][] maps, int i, int j){
            ArrayDeque<int[]> q = new ArrayDeque<>();
            q.offer(new int[] {i, j, 1}); // 위치 저장 및 방문
            v[i][j] = true;

            while (!q.isEmpty()) {
                int[] ij = q.poll();
                int ni = ij[0];
                int nj = ij[1];
                int distance = ij[2];

                if (ni == row - 1 && nj == col - 1) { // 목표 지점 도달
                    return distance;
                }

                for (int d = 0; d < 4; d++) {
                    int newi = di[d] + ni;
                    int newj = dj[d] + nj;

                    if (newi >= 0 && newi < row && newj >= 0 && newj < col && !v[newi][newj] && maps[newi][newj] == 1) {
                        v[newi][newj] = true;
                        q.offer(new int[]{newi, newj, distance + 1});
                    }
                }
            }

            return -1; // 도달할 수 없는 경우
        }
    }
