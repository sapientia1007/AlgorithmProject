import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); 

        for (int i=0; i<T; i++) {
            Map<String, List<String>> clothes = new HashMap<>();

            int N = Integer.parseInt(br.readLine()); 
            int answer = 1;

            for (int j=0; j<N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                String clothName = st.nextToken();
                String clothType = st.nextToken();
                clothes.computeIfAbsent(clothType, k -> new ArrayList<>()).add(clothName);
            }

            for (List<String> c : clothes.values()) {
                answer *= (c.size() + 1);
            }

            System.out.println(answer-1);
        }
        br.close();

    }
}