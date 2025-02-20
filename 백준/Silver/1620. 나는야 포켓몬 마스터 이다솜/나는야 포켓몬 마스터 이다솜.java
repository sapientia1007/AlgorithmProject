import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken()); 

        // 포켓몬 도감 저장
        HashMap<String, Integer> nameToNumber = new HashMap<>();
        ArrayList<String> numberToName = new ArrayList<>(N + 1); // 1번부터 시작

        numberToName.add("");

        for (int i = 1; i <= N; i++) {
            String pokemon = br.readLine();
            nameToNumber.put(pokemon, i);
            numberToName.add(pokemon);
        }

        for (int i = 0; i < M; i++) {
            String query = br.readLine();
            if (Character.isDigit(query.charAt(0))) {
                // 숫자가 들어오면 이름 출력
                int number = Integer.parseInt(query);
                sb.append(numberToName.get(number)).append("\n");
            } else {
                // 문자열이 들어오면 번호 출력
                sb.append(nameToNumber.get(query)).append("\n");
            }
        }

        System.out.print(sb);
    }
}
