import java.io.*;
import java.util.*;

class Main {
    static int[][] arr ;
    static int cntMinusOne = 0;
    static int cntZero = 0;
    static int cntOne = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0, 0, N);

        System.out.println(cntMinusOne);
        System.out.println(cntZero);
        System.out.println(cntOne);
        
        br.close();
    }

    static void divide(int x, int y, int size) {
        if (check(x, y, size)) { // 현재 영역이 모두 같은 숫자인지 확인
            int num = arr[x][y]; // 현재 영역의 숫자 값
            if (num == -1) cntMinusOne++;
            if (num == 0) cntZero++;
            if (num == 1) cntOne ++;
            return;
        }

        // 현재 영역이 모두 같은 숫자가 아니라면, 크기를 3등분하여 재귀 호출
        int newSize = size/3;
        for (int i=x; i<x+size; i+=newSize) { // 행 
            for (int j=y; j<y+size; j+=newSize) { // 열
                divide(i, j, newSize);
            }
        }
    }

    static boolean check(int x, int y, int size) {
        for (int i=x; i<x+size; i++) {
            for (int j=y; j<y+size; j++) {
                if (arr[x][y] != arr[i][j]) return false;
            }
        }
        return true;
    }
}