import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; 
        long res = 0L;

        int N = Integer.parseInt(br.readLine()); // 시험장의 개수
        int[] arr = new int[N] ; // 응시자 배열
        
        st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken()); // 응시자 수 배열 
        }

        st = new StringTokenizer(br.readLine()) ;

        int B = Integer.parseInt(st.nextToken()) ; // 총감독관이 감시할 수 있는 응시자의 수
        int C = Integer.parseInt(st.nextToken()) ; // 부감독관이 감시할 수 있는 응시자의 수 

        res += N;
        for (int i=0; i<N; i++) {
            arr[i] -= B;
        }

        for (int i=0; i<N; i++) {
            if (arr[i] > 0) {
                res += (arr[i] + C - 1) / C; // 올림 나눗셈
            }
        }

        System.out.println(res);
     }
} 