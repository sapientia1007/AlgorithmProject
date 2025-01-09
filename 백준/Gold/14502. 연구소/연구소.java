import java.io.*;
import java.util.*;

/*
 * 0 : 빈칸 / 1: 벽 / 2: 바이러스 => 바이러스는 0이 공간으로 퍼져나감 (1 벽이 있어야함)
 * 입력 :
 * 		지도의 세로크기N 가로크기M
 * 		N개의 줄 -> 지도 모양 
 * 조건 : 벽을 3개 세울 것
 * 출력 : 얻을 수 있는 안전 영역 최대크기 => 최종 0인 곳 개수 출력
 */

public class Main{
	static int N; static int M; static int[][] arr; static boolean[][] v;
	static final int[] di = {-1, 0, 1, 0};
	static final int[] dj = {0, -1, 0, 1};
	static int cnt = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
		arr = new int[N][M]; v = new boolean[N][M];
		for (int i=0; i<N; i++) {
			String[] nums = br.readLine().split(" ");
			for (int j=0; j<M; j++) {
				int numbers = Integer.parseInt(nums[j]);
				arr[i][j] = numbers; // 지도 정보 입력
			}	
		}	
		setWallAndCount(0,0);
		System.out.println(cnt);
		br.close();
	}
	
	static void setWallAndCount(int count, int start) {
		if (count == 3) {
			cnt = Math.max(cnt, bfs());
			return;
		}
		for (int i=start; i<N*M; i++) {
			int row = i/M; int col =i%M; // 행열계산
			if (arr[row][col] == 0) { //0인경우만 벽 세울 수 있음
				arr[row][col] = 1;
				setWallAndCount(count+1, i+1);
				arr[row][col] = 0; // 백트래킹 -> 다시 빈 공간으로 돌리기
			}
		}
	}

	// 처리 => 2(바이러스)가 1이 아닌 곳 피하고, 0인 곳을 통해 계속 bfs 진행 (0:빈칸/1:벽/2:바이러스) 
	// 최종 배열에서 0인 경우를 크게 봤을 때 크기 리턴
	static int bfs() {
		int[][] temp = new int[N][M];
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				temp[i][j] = arr[i][j];
				v[i][j]=false;
			}
		}
		ArrayDeque<int[]> q = new ArrayDeque<>();
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if (temp[i][j] == 2) {
					q.offer(new int[] {i,j});
				}
			}
		}	
		while (!q.isEmpty()) {
			int[] ij = q.poll();
			int i = ij[0]; int j = ij[1];
			for (int d=0; d<4; d++) {
				int ni = i+di[d]; int nj = j+dj[d];
				if (0<=ni && ni<N && 0<=nj && nj<M && 
						!v[ni][nj] && arr[ni][nj]==0) { 
					v[ni][nj] = true;
					temp[ni][nj] = 2;
					q.offer(new int[] {ni,nj});
				} 
			}
		}	
		int safeZone = 0;
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if (temp[i][j] == 0) safeZone++;
			}
		}
		return safeZone;
	}
}
