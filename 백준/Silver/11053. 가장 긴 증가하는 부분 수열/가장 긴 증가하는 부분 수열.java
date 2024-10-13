import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()) ; // 수열의 크기
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // answer list
        List<Integer> answer = new ArrayList<>();
        answer.add(0);

        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            if (arr[i] > answer.get(answer.size()-1)) {
                answer.add(arr[i]);
            }
            else {
                int left = 0; int right = answer.size();

                while (left < right) {
                    int mid = (left + right) / 2;
                    if (answer.get(mid) >= arr[i]) {
                        right = mid;
                    } else left = mid+1;
                }
                answer.set(right, arr[i]);
            }
        }
        System.out.println(answer.size()-1);

        br.close();
    }
}
