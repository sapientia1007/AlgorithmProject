
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 수의 개수
        Integer[] arr = new Integer[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, Collections.reverseOrder()); // 내림차순 정렬

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int a : arr) {
            bw.write(a+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
