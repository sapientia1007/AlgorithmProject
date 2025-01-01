import java.io.*;
import java.util.*;

public class Main {

    static int[] di = {0,0,-1,1};
    static int[] dj = {1,-1,0,0};
    static boolean[][] v;
    static int[][] arr ;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int [N][N];
        v = new boolean[N][N];

        ArrayList<Integer> result = new ArrayList<>();
        for (int i=0; i<N; i++) {
            String inpt = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = inpt.charAt(j)-'0';
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++){
                if (!v[i][j] && arr[i][j]==1) {
                    result.add(bfs(i,j));
                }
            }
        }

        Collections.sort(result);
        System.out.println(result.size());
        for (int i : result) System.out.println(i);
        br.close();
    }

    static int bfs(int i, int j){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        v[i][j] = true;
        q.offer(new int[] {i, j});

        int cnt = 1;

        while (!q.isEmpty()) {
            int[] ij = q.poll();
            int ii = ij[0]; int jj = ij[1];

            for (int d=0; d<4; d++) {
                int ni = ii + di[d];
                int nj = jj + dj[d];
                if (0<=ni && ni<N && 0<=nj && nj<N && !v[ni][nj] && arr[ni][nj] == 1) {
                    v[ni][nj] = true;
                    q.offer(new int[] {ni, nj});
                    cnt ++;
                }
            }
        }
        return cnt;
    }
}
