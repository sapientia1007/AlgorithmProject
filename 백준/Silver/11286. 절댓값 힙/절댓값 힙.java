import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 연산의 개수

        PriorityQueue<Integer> arr  = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int abs1 = Math.abs(o1); int abs2 = Math.abs(o2);

                if (abs1 == abs2) {
                    return Integer.compare(o1, o2);
                } else {
                    return Integer.compare(abs1, abs2);
                }
            }
        });

        // 0 = 배열에서 절댓값이 가장 작은 값 출력, 배열에서 제거
        // 0이 아니라면 = 배열에 해당 값을 넣는 연산

        for (int i=0; i<N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if (arr.isEmpty()) System.out.println(0);
                else System.out.println(arr.poll());
            }
            else {
                arr.offer(x);
            }
        }

        br.close();
    }
}
