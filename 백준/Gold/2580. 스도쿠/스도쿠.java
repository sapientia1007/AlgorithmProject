import java.io.*;
import java.util.*;

public class Main{
	static int[][] arr = new int[9][9];
	static StringBuilder sb = new StringBuilder();

	// 도우미 함수: 주어진 셀에 숫자를 놓을 수 있는지 확인
	static boolean isValid(int row, int col, int num) {
		// 행 확인
		for (int i = 0; i < 9; i++) {
			if (arr[row][i] == num) {
				return false;
			}
		}
		// 열 확인
		for (int i = 0; i < 9; i++) {
			if (arr[i][col] == num) {
				return false;
			}
		}
		// 3x3 서브 그리드 확인
		int startRow = row / 3 * 3;
		int startCol = col / 3 * 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (arr[startRow + i][startCol + j] == num) {
					return false;
				}
			}
		}
		return true;
	}

	// 스도쿠를 해결하는 백트래킹 함수
	static boolean solveSudoku() {
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				if (arr[row][col] == 0) { // 빈 셀 찾기
					for (int num = 1; num <= 9; num++) { // 가능한 모든 숫자 시도
						if (isValid(row, col, num)) {
							arr[row][col] = num; // 숫자 놓기
							if (solveSudoku()) { // 다음 숫자 놓기 위해 재귀 호출
								return true;
							}
							arr[row][col] = 0; // 유효하지 않으면 백트래킹
						}
					}
					return false; // 가능한 숫자가 없으면 false 반환
				}
			}
		}
		return true; // 모든 셀이 채워지면 true 반환
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken()); // 그리드 채우기
			}
		}

		if (solveSudoku()) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(arr[i][j]).append(" ");
				}
				sb.append('\n');
			}
			System.out.println(sb);
		} 
	}
}
