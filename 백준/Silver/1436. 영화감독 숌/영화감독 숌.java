import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        Long start = 666L;

        while (count < N) {
            if (String.valueOf(start).contains("666")) {
                count += 1;
                if (count == N) {
                    System.out.println(start);
                    break;
                } 
            } 
            start += 1;
        }
        br.close();
    }
}