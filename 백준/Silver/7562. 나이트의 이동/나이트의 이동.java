import java.io.*;
import java.util.*;

class Main {

    static int[][] arr ; static boolean[][] visited;
    static int[] di = new int [] {+2, +1, -2, -1, +2, +1, -2, -1};
    static int[] dj = new int [] {+1, +2, +1, +2, -1, -2, -1, -2};
    static int l;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스

        for (int i=0; i<T; i++) {
            l = Integer.parseInt(br.readLine()); // 체스판의 한 변의 길이
            arr = new int [l][l];
            visited = new boolean [l][l];

            // 현재 위치
            String[] currentInpt = br.readLine().split(" ");
            int[] current = new int [] {Integer.parseInt(currentInpt[0]), Integer.parseInt(currentInpt[1])};
          
            // 목표 위치
            String[] gaolInpt = br.readLine().split(" ");
            int[] goal = new int [] {Integer.parseInt(gaolInpt[0]), Integer.parseInt(gaolInpt[1])};
          
            System.out.println(bfs(current, goal, visited)); // 최단거리니까 너비우선탐색 
        }

        br.close();
    }

    static int bfs(int[] currentMatrix, int[] goalMatrix, boolean[][] v) {
        
        ArrayDeque<int[]> q = new ArrayDeque<>();    
        v[currentMatrix[0]][currentMatrix[1]] = true;
        q.offer(new int[] {currentMatrix[0], currentMatrix[1], 0});

        while (!q.isEmpty()) {
            int[] ij = q.poll();
            int i = ij[0]; int j = ij[1];
            int m = ij[2];

            if (i == goalMatrix[0] && j == goalMatrix[1]) return m;

            for (int d=0; d<8; d++) {
                int ni = di[d]+i;
                int nj = dj[d]+j;

                if (0<=ni && ni<l && 
                    0<=nj && nj<l && !v[ni][nj]){
                        v[ni][nj] = true;
                        q.offer(new int[] {ni, nj, m+1});
                    }
            }
            
        }
        return -1;
    }
}