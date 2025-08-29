import java.io.*;
import java.util.*;

class Main {
    static int[][] arr;
    static boolean[][] v; 
    static int N, M;
    static int[] di = new int[] {-1,0,1,0};
    static int[] dj = new int[] {0,1,0,-1}; 
    static int cleanedCnt ;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 방 크기 N
        M = Integer.parseInt(st.nextToken()); // 방 크기 M
        arr = new int[N][M]; v = new boolean[N][M];

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()); 
        int c = Integer.parseInt(st.nextToken()); 
        int d = Integer.parseInt(st.nextToken());


        // (r,c), 로봇이 바라보고 있는 방향 d(0: 북, 1:동, 2:남, 3:서)
        for (int i=0; i<N; i++){
            String[] inpt = br.readLine().split(" ");
            for (int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(inpt[j]);
            }
        }

        bfs(r,c,d);
    }

    static void bfs(int r, int c, int d){ 
        cleanedCnt = 0;
        v[r][c] = true;

        while (true) {
            // 현재 칸이 청소되어 있지 않다
            if (arr[r][c] == 0) {
                arr[r][c] = 2; // 청소 완료 표시
                cleanedCnt++;
            }
            
            boolean cleanAround = false;

            // 현재 위치에서 주변 4칸 중 청소되지 않은 빈칸이 있는지 확인
            for (int i=0; i<4; i++) {
                d = (d+3)%4; //왼쪽으로 방향 전환
                int ni = r + di[d];
                int nj = c + dj[d];

                if (0<=ni && ni<N && 0<=nj && nj<M && arr[ni][nj] == 0) {
                    r = ni; c = nj; cleanAround = true; break;
                }
            }

            if (cleanAround) continue;

            // 4칸 다 청소 불가면 후진
            int back = (d+2) % 4;
            int br = r + di[back];
            int bc = c + dj[back];

            // 후진 위치에서 벽이 있거나 벗어나면 종료
            if (br<0 || br>=N || bc<0 || bc>=M || arr[br][bc] == 1) {
                System.out.println(cleanedCnt);
                break;
            } else {
                r = br; c = bc;
            }
        }
    }
}