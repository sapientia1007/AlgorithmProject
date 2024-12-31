import java.io.*;
import java.util.*;

public class Main {
    static final int[] di = {-1,0,1,0};
    static final int[] dj = {0,1,0,-1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];

        //  배열 저장 & 높이 기준
        int maxHeight = 0;
        for (int i=0; i<N; i++){
            String[] inptNumbers = br.readLine().split(" ");
            for (int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(inptNumbers[j]);
                if (arr[i][j] > maxHeight) maxHeight=arr[i][j];
            }
        }

        int answer = 1; // 최소한 1개의 안정 영역 존재
        for (int h=1; h<=maxHeight; h++) {
            boolean[][] v = new boolean[N][N];
            int cnt = 0;
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++){
                    if (!v[i][j] && arr[i][j] > h) {
                        bfs(arr,v,N,h,i,j);
                        cnt++;
                    }
                }
            }
            if (cnt > answer) answer = cnt;
        }

        System.out.println(answer);
        br.close();
    }
    
    static void bfs(int[][] arr,boolean[][] visited, int N, int H, int startI, int startJ) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {startI,startJ});
        visited[startI][startJ]= true;
        while (!q.isEmpty()){
            int[] ij = q.poll();
            int i = ij[0]; int j = ij[1];
            for (int d=0; d<4; d++) {
                int ni = i + di[d];
                int nj = j + dj[d];
                if (0<=ni && ni<N && 0<=nj && nj<N && !visited[ni][nj] && arr[ni][nj] > H){
                    visited[ni][nj] = true;
                    q.offer(new int[] {ni,nj});
                }
            }
        }
    }
}
