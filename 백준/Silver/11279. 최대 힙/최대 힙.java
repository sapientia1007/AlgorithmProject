import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2) -> Integer.compare(o2,o1));

        for (int i=0; i<N; i++) {
            int inpt = Integer.parseInt(br.readLine());
            if (inpt == 0) {
                if (pq.isEmpty()) {
                    bw.write("0\n");
                } else {
                    bw.write(pq.poll() + "\n");
                }
            } else pq.offer(inpt);
        }
        bw.close();
        br.close();
    }
}
