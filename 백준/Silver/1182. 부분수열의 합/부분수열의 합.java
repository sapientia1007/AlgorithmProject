import java.io.*;
import java.util.*;


public class Main {

    static int c = 0; static int n; static int k; static int[] arr ;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken()); k= Integer.parseInt(st.nextToken());
        arr = new int[n];
        st= new StringTokenizer(br.readLine(), " ");
        for (int i =0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        findSum(0, 0);
        System.out.println(k ==0 ? c-1:c); // 0인 경우 고려 -> 겹침 -> -1

    }
    static void findSum(int idx, int sum){ // 원소 탐색
        if (idx == n){ // 선탠학 원소와의 합이 k와 같으면 c++;
            if (sum == k){
                c ++;
            }
            return;
        }
        // 그렇지 않으면 다음 탐색 진행
        findSum(idx+1, sum+arr[idx]);  // 원소를 선택했을때 합+원소를 전달
        findSum(idx+1, sum); // 원소를 선택하지 않았을 때 합 전달
    }
}