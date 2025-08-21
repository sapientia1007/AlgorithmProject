import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 전체 바구니 개수 
        int M = Integer.parseInt(st.nextToken()); // 바구니 순서 변경 횟수

        int[] arr = new int[N];
        for (int i=1; i<N+1; i++) {
            arr[i-1] = i;
        }

        for (int m=0; m<M; m++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            // arr[i-1] ~ arr[j-1]를 역순으로 바꾸기
            for (int start = i, end = j; start<end; start++, end--) {
                int temp = arr[start-1];
                arr[start-1] = arr[end-1];
                arr[end-1] = temp;
            }
        }

        for (int a : arr) System.out.print(a + " ");

        br.close();
    }
}