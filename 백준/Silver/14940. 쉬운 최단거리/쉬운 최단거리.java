import java.io.*;
import java.util.*;

class Main {
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};
    static int[][] arr;
    static int[][] resArr;
    static boolean[][] visited;
    static int n, m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        resArr = new int[n][m];
        visited = new boolean[n][m];

        int startI = -1, startJ = -1;

        for (int i = 0; i < n; i++) {
            String[] inpt = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(inpt[j]);
                resArr[i][j] = -1; 
                if (arr[i][j] == 0) resArr[i][j] = 0;  
                if (arr[i][j] == 2) {
                    startI = i;
                    startJ = j;
                    resArr[i][j] = 0;
                }
            }
        }

        bfs(startI, startJ);

        for (int i=0; i<n; i++){ 
            for (int j=0; j<m; j++) {
                System.out.print(resArr[i][j]+ " ");
            }
            System.out.println();
        }
        br.close();
    }

    static void bfs(int i, int j) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {i,j});
        visited[i][j] = true;

        while(!q.isEmpty()){
            int[] current = q.poll();
            i = current[0]; j=current[1];

            for (int d=0; d<4; d++){
                int ni = i+di[d];
                int nj = j+dj[d];

                if (0<=ni && ni<n && 0<=nj && nj<m && arr[ni][nj] == 1 && !visited[ni][nj]) {
                    q.offer(new int[] {ni, nj});
                    visited[ni][nj] = true;
                    resArr[ni][nj] = resArr[i][j] + 1;
                }
            }
        }
    }
}