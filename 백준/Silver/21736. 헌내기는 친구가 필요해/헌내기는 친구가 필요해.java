import java.io.*;
import java.util.*;

// O : 빈공간 / X : 벽 / I : 도연 / P : 사람
        
class Main {
    static int[] dx = new int[] {-1,0,1,0};
    static int[] dy = new int[] {0,1,0,-1};
    static boolean[][] v ;
    static String[][] arr;
    static int p ;
    static int N, M;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new String[N][M];
        v = new boolean[N][M];
        p = 0;

        for (int i=0; i<N; i++) {
            String[] inpt = br.readLine().split("");
            for (int j=0; j<M; j++) {
                arr[i][j] = inpt[j];
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (arr[i][j].equals("I")) bfs(i,j);
            }
        }

        if (p == 0) System.out.println("TT");
        else System.out.println(p);

        br.close();
    }

    static void bfs(int i, int j) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {i, j}); v[i][j] = true;
        while (!q.isEmpty()) {
            int[] xy = q.poll();
            i = xy[0]; j = xy[1];

            for (int d=0; d<4; d++) {
                int nx = i+dx[d];
                int ny = j+dy[d];

                if (0<=nx && nx<N && 0<=ny && ny<M && !v[nx][ny] && !arr[nx][ny].equals("X")) {
                    v[nx][ny] = true;
                    if (arr[nx][ny].equals("P")) p += 1;
                    q.offer(new int[] {nx, ny});
                } 
            }
        }
    }
}