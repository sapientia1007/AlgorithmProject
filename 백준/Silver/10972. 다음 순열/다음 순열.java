import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int idx = -1;
        for (int i=N-1; i>0; i--) {
            if (arr[i] > arr[i-1])  { // 꺾이는 부분 
                idx = i-1;
                break;
            }
        }


        if (idx == -1) {
            System.out.println(-1);
        } else {
            for (int i = N-1; i>idx; i--) {
                // 꺾이는 지점보다 큰 값 중 가장 작은 값 찾기
                if (arr[i] > arr[idx]){
                    swap(arr, idx, i);
                    break;
                }
            }
            Arrays.sort(arr, idx + 1, N); // 꺾이는 지점 이후 오름차순

            StringBuilder sb = new StringBuilder();
            for (int num : arr){
                sb.append(num).append(" ");
            }
    
            System.out.println(sb.toString());
        }


        br.close();
    }
    static void swap(int[] arr, int idx1, int idx2){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}