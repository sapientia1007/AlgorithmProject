import java.io.*;
import java.util.*;

/*
 * 입력 : 
 * 		첫재줄 - N,M,K
 * 		N : 통로의 세로 길이
 * 		M : 통로의 가로 길이
 * 		K : 음식물 쓰레기의 개수
 * 		K개의 줄 -
 * 		음식물이 떨어진 좌표(r,c) => 배열 arr[N][M]
 * 출력 : 
 * 		음식물의 크기
 * 처리  :
 * 		dfs 사용 
 */

public class Main{
	static int N,M,K;
	static boolean[][] arr;
	static boolean[][] v;
	static int cnt = 0; static int max = 0 ;
	static final int[] di = {-1,0,1,0};
	static final int[] dj = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken()); K = Integer.parseInt(st.nextToken());
		arr = new boolean[N][M]; v = new boolean[N][M];
		
		for (int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				arr[i][j] = false;
			}
		}
		for (int i=0; i<K; i++) {
			String[] nums = br.readLine().split(" ");
			int row = Integer.parseInt(nums[0]);
			int col = Integer.parseInt(nums[1]);
			arr[row-1][col-1] = true;
		}
		
        for (int i = 0; i<N; i++) {
            for (int j = 0; j<M; j++) {
                if (!v[i][j] && arr[i][j]) { // 방문하지 않았고 음식물이라면
                    dfs(i, j); //재귀탐색
                    max = Integer.max(max, cnt); // 가장 큰 쓰레기 크기를 구하기 위해 max
                    cnt = 0;
                }
            }
        }

		System.out.println(max);
		br.close();
	}
	static void dfs(int i, int j) {
		v[i][j] = true;
		cnt ++;
		for (int d=0; d<4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			// 해당 배열 내에서 음식물이고, 방문하지 않았으면 재귀
			if (0<=ni && ni<N && 0<=nj && nj<M && arr[ni][nj] && !v[ni][nj] ) {
				dfs(ni, nj);
			}
		}
	}
}
