import java.util.*;
import java.io.*;

public class Main {
    
    static int N; static int M; static int count = 0;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        LinkedList<Integer> q = new LinkedList<>();
        for (int i=1; i<=N; i++) q.add(i);
        int[] arr = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());// 뽑아내려고 하는 숫자
            int target_idx = q.indexOf(arr[i]); // 목표하는 숫자 인덱스 저장

            int half_idx;

            if (q.size() % 2 == 0){
                half_idx = q.size()/2-1;
            } else {
                half_idx = q.size()/2;
            }

            if (target_idx <= half_idx) { // 이진으로 볼 때 앞쪽 배열기준 -> 앞에서 빼기
                for (int j = 0; j < target_idx; j++) {
                    int temp = q.pollFirst();
                    q.offerLast(temp);
                    count++;
                }
            } else {
                for (int j=0; j<q.size()-target_idx; j++) { // 뒤쪽 배열 기준 -> 뒤에서 빼기
                    int temp = q.pollLast();
                    q.offerFirst(temp);
                    count++;
                }
            }
            q.pollFirst(); // 맨앞쪽 요소 제거
        }
        System.out.println(count);
        br.close();
    }
}
