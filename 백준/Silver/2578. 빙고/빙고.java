import java.io.*;
import java.util.*;

/*
입력 :
    1~5줄 : 빙고판 배열 저장 (5x5)
    5~10줄 : 사회자가 부르는 숫자 1차원 배열

출력 :
    사회자가 부르는 숫자를 빙고판 배열에서 0으로 변경
    가로, 세로, 대각선으로 5개의 숫자가 모두 0이면 -> cnt ++
    cnt ==3이면 종료! => 해당 사회자의 숫자 인덱스 +1 출력

 */
public class Main {
    static int[][] arr; static int[] pick = new int[25];
    static int cnt;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        cnt =  0;
        arr = new int[5][5];
        // 빙고판 입력
        for (int i=0; i<5; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 사회자 배열 저장
        int idx=0;
        for (int i=0; i<5; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<5; j++){
                pick[idx++] = Integer.parseInt(st.nextToken());
            }
        }

        // 사회자 배열의 값과 일치하는 값 0으로 변경 -> 해당 row와 col에 맞춰서 빙고 확인 
        for (int k=0; k<25; k++) {
            int num = pick[k];
            for (int r=0 ; r<5; r++){
                for (int c=0; c<5; c++) {
                    if (arr[r][c] == num) arr[r][c] = 0;
                }
            }
            rCheck();
            cCheck();
            lrCheck();
            rlCheck();

            if (cnt >= 3) { // 빙고가 3개 이상이면 사회자의 배열 인덱스+1 출력
                System.out.println(k+1);
                break;
            }
            cnt = 0;
        }

        br.close();
    }

    static void rlCheck() {
        int zeroCount=0;
        for (int i = 0; i < 5; i++) {
            if (arr[i][4-i] == 0) zeroCount++;
        }
        if (zeroCount == 5) cnt ++;
    }

    static void lrCheck() {
        int zeroCount=0;
        for (int i = 0; i < 5; i++) {
            if (arr[i][i] == 0) zeroCount++;
        }
        if (zeroCount == 5) cnt ++;
    }


    static void cCheck() {
        for (int i = 0; i < 5; i++) {
            int zeroCount=0;
            for (int j = 0; j < 5; j++) {
                if (arr[j][i] == 0) zeroCount++;
            }
            if (zeroCount == 5) cnt++;
        }
    }

    static void rCheck() {
        for (int i = 0; i < 5; i++) {
            int zeroCount = 0;
            for (int j = 0; j < 5; j++) {
                if (arr[i][j] == 0) zeroCount++;
            }
            if (zeroCount == 5) cnt++;
        }
    }
}