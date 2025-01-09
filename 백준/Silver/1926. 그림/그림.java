import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr;

    static int[] di = {-1,0,1,0};
    static int[] dj = {0,1,0,-1};

    static int n, m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> result = new ArrayList<>();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for (int i=0 ; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] v = new boolean[n][m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (arr[i][j] == 1 && !v[i][j]) result.add(bfs(i, j, v));
            }
        }

        System.out.println(result.size());

        if (!result.isEmpty()) {
            System.out.println(Collections.max(result));
        }
        else {
            System.out.println(0);
        }
        br.close();

    }

    public static int bfs(int i, int j, boolean[][] v){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        v[i][j] = true;
        q.offer(new int[] {i, j});

        int cnt = 1;
        while (!q.isEmpty()) {
            int[] idx = q.poll();
            for (int d=0; d<4; d++){
                int ii = idx[0] + di[d];
                int jj = idx[1] + dj[d];
                if (0<=ii && ii<n && 0<=jj && jj<m && !v[ii][jj] && arr[ii][jj] == 1) {
                    v[ii][jj] = true;
                    q.offer(new int[] {ii, jj});
                    cnt += 1;
                }
            }
        }
        return cnt;

    }
}
