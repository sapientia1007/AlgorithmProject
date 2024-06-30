import java.io.*;
import java.util.*;

/*
 * 1. 해당 row에 없는 숫자 확인 (1~9)
 * 2. 해당 col에 없는 숫자 확인
 * 3. dfs 방식으로 경우의 수 확인
 * 입력 : 9x9 배열 입력 arr[9][9]
 * if (arr[i][j] == 0) 해당 열과 행에 없는 숫자 확인 -> 해당 숫자로 dfs()
 */

public class Main {
	static int[][] arr =  new int[9][9];
	static StringBuilder sb;

	// 스도쿠 해결하는 백트래킹 함수
	static boolean check() {
		for (int row=0; row<9; row++){
			for (int col=0; col<9; col++){
				if (arr[row][col] == 0){
					for (int num=1; num<=9; num++){
						if (isValid(row, col, num)) { // num 숫자가 해당 배열에 맞는지 확인
							arr[row][col] = num; // 적합하다면 추가
							if (check()) {
								return true;
							}
							arr[row][col] = 0;
						}
					}
					return false;
				}
			}
		}
		return true;
	}

	// 해당 위치에 num이 들어가는게 맞나 확인 
	static boolean isValid(int row, int col, int num) {
		// 해당 행과 열에 없는 숫자인지 확인 
		for (int i=0; i<9; i++) {
			if (arr[row][i] == num) {
				return  false;
			}
		}
		for (int i=0; i<9; i++){
			if (arr[i][col] == num){
				return false;
			}
		}
		// 서브 그리드 확인
		int startRow = row/3*3;
		int startCol = col/3*3;
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				if (arr[startRow+i][startCol+j] == num) return false;
			}
		}
		return true;
	}


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder() ;
		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken()); // 배열 저장
			}
		}

		if (check()) {
			for (int i=0; i<9; i++){
				for (int j=0; j<9; j++) {
					sb.append(arr[i][j]).append(" ");
				}
				sb.append("\n");
			}
		}

		// 결과
		System.out.println(sb);

	}
}