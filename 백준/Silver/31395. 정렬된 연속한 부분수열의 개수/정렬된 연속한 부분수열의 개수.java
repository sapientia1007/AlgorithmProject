import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long cnt = 0;
        int arrLength = 1; // 부분 수열 길이 (기본 1)

        // i, j는 1과 N 사이
        for (int i=1; i<N; i++) {
            if (arr[i] >= arr[i-1]) arrLength ++;
            else {
                // 길이로 나올 수 있는 부분 조합 갯수 구하기
                cnt += (long) (arrLength) * (arrLength+1) / 2;
                arrLength = 1;
            }
        }

        cnt += (long) (arrLength) * (arrLength + 1) / 2;

        System.out.println(cnt);
        br.close();
    }
}
