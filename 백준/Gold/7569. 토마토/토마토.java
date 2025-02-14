import java.io.*;
import java.util.*;

class Main {
    static int[][][] tomato;
    static boolean[][][] visited;
    static int[] di = new int[] {-1, 0, 0, 1, 0, 0};
    static int[] dj = new int[] {0, 1, -1, 0, 0, 0};
    static int[] dk = new int[] {0, 0, 0, 0, 1, -1};
    static int M, N, H;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 세로
        H = Integer.parseInt(st.nextToken()); // 상자의 수

        tomato = new int[H][N][M];
        visited = new boolean[H][N][M];

        int total = 0 ;
        for (int i=0; i<H; i++){
            for (int j=0; j<N; j++) {
                st = new StringTokenizer(br.readLine());

                for (int k=0; k<M; k++) {
                    tomato[i][j][k] = Integer.parseInt(st.nextToken());
                    if (tomato[i][j][k] == 0) total++; // 익지 않은 토마토 개수 세기
                }
            }
        }

        int days = bfs();
        System.out.println(total == 0 ? 0 : (days == -1 ? -1 : days)); // 결과 출력
        br.close();
        
    }

    static int bfs() {
        ArrayDeque<int[]> q = new ArrayDeque<>();

        int notRipened= 0; // 익지 않은 토마토 개수
        int maxDays = 0;

         // 익은 토마토 위치를 큐에 넣음
         for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (tomato[h][n][m] == 1) {
                        q.offer(new int[]{h, n, m, 0});
                        visited[h][n][m] = true;
                    } else if (tomato[h][n][m] == 0) {
                        notRipened++;
                    }
                }
            }
        }

        if (notRipened == 0) return 0; // 처음부터 모든 토마토가 익어있다면 0일

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int h = cur[0], n = cur[1], m = cur[2], days = cur[3];
            maxDays = Math.max(maxDays, days);

            for (int d = 0; d < 6; d++) {
                int nh = h + di[d];
                int nn = n + dj[d];
                int nm = m + dk[d];

                if (0 <= nh && nh < H && 0 <= nn && nn < N && 0 <= nm && nm < M) {
                    if (!visited[nh][nn][nm] && tomato[nh][nn][nm] == 0) {
                        visited[nh][nn][nm] = true;
                        tomato[nh][nn][nm] = 1;
                        q.offer(new int[]{nh, nn, nm, days + 1});
                        notRipened--;
                    }
                }
            }
        }

        return (notRipened == 0) ? maxDays : -1; // 익지 않은 토마토가 남아있으면 -1 반환
    }
}