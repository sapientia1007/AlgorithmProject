import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2) -> Integer.compare(o2,o1));

        for (int i=0; i<N; i++) {
            int inpt = Integer.parseInt(br.readLine());
            if (inpt == 0) {
                if (pq.isEmpty()) System.out.println(0);
                else System.out.println(pq.poll());
            }
            else pq.offer(inpt);
        }
        br.close();
    }
}
