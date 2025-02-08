import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> cardCount = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int cardNum = Integer.parseInt(st.nextToken());
            cardCount.put(cardNum, cardCount.getOrDefault(cardNum, 0) + 1);
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int numToFind = Integer.parseInt(st.nextToken());
            result.append(cardCount.getOrDefault(numToFind, 0)).append(" ");
        }

        System.out.println(result.toString().trim());
        br.close();
    }
}
