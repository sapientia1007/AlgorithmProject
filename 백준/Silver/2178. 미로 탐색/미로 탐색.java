import java.io.*;
import java.util.*;

/*
* 1 : 이동할 수 있는 칸 & 0 : 이동할 수 없는 칸
* (1,1) 출발 / (N,M) 이동 => 최소의 칸 수 = BFS
* */
public class Main{
    static final int[] di = {-1,0,1,0};
    static final int[] dj = {0,1,0,-1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inptLine = br.readLine();
        int N = Integer.parseInt(inptLine.split(" ")[0]);
        int M = Integer.parseInt(inptLine.split(" ")[1]);
        int[][] arr = new int[N][M]; boolean[][] v = new  boolean[N][M];

        //  배열 저장
        for (int i=0; i<N; i++){
            String[] inptNumbers = br.readLine().split("");
            for (int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(inptNumbers[j]);
            }
        }

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0,0});
        v[0][0]= true;
        while (!q.isEmpty()){
            int[] ij = q.poll();
            int i = ij[0]; int j = ij[1];
            for (int d=0; d<4; d++) {
                int ni = i + di[d];
                int nj = j + dj[d];
                if (0<=ni && ni<N && 0<=nj && nj<M && !v[ni][nj] && arr[ni][nj] == 1){
                    v[ni][nj] = true;
                    arr[ni][nj] = arr[i][j] + 1;
                    q.offer(new int[] {ni,nj});
                }
            }
        }

        System.out.println(arr[N-1][M-1]);
        br.close();
    }
}
