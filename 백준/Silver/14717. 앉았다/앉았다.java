import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int first = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());

        // 상대방 패
        ArrayList<Integer> card = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            card.add(i);
            card.add(i);
        }

        // 영학이 카드 제외
        card.remove(Integer.valueOf(first));
        card.remove(Integer.valueOf(second));

        int win = 0, total = 0;
        for (int i = 0; i < card.size(); i++) {
            for (int j = i + 1; j < card.size(); j++) {
                int card1 = card.get(i);
                int card2 = card.get(j);

                if (rank(first, second) > rank(card1, card2)) win++;
                total++;
            }
        }

        System.out.println(String.format("%.3f", (double) win/total));
        br.close();
    }

    static int rank(int x, int y) {
        return (x == y) ? 9 + x : (x + y) % 10;
    }
}
