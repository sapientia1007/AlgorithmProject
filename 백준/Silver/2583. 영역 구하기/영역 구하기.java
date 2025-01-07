import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr;
    static boolean[][] v;
    static int[] di = {-1,0,1,0};
    static int[] dj = {0,1,0,-1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()); int N = Integer.parseInt(st.nextToken()); int K = Integer.parseInt(st.nextToken());
        arr = new int[M][N]; v = new boolean[M][N];

        for (int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken()); int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken()); int y2 = Integer.parseInt(st.nextToken());


            for (int y=y1; y<y2; y++) {
                for (int x=x1; x<x2; x++) {
                    arr[y][x] = 1;
                }
            }
        }

        ArrayList<Integer> result = new ArrayList();

        for (int i=0; i<M; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] != 1 && !v[i][j]) result.add(bfs(i, j, M, N));
            }
        }

        System.out.println(result.size());

        Collections.sort(result);

        for (int r : result) System.out.print(r+ " ");
        br.close();
    }

    public static int bfs(int x, int y, int M, int N) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        v[x][y] = true;
        q.offer(new int[] {x, y});
        int cnt = 1;
        while (!q.isEmpty()) {
            int[] next = q.poll();
            int i = next[0]; int j = next[1];
            for (int d=0; d<4; d++) {
                int ii = i + di[d];
                int jj = j + dj[d];
                if (ii >= 0 && ii < M && jj >= 0 && jj < N) {
                    if (arr[ii][jj] != 1 && !v[ii][jj]) {
                        v[ii][jj] = true;
                        q.offer(new int[]{ii, jj});
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}
