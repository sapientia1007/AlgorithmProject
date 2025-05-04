import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken());
        Map<String, String> dict = new HashMap<>();
        for (int i=0; i<N; i++) {  // 적어놓은 사이트 비밀번호
            String[] inpt = br.readLine().split(" ");
            dict.put(inpt[0], inpt[1]);
        }

        for (int j=0; j<M; j++) {
            String toFind = br.readLine();
            System.out.println(dict.get(toFind));
        }
        br.close();
    }
}