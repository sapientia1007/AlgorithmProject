import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] k = new int[3]; int[] s = new int[3];
        for (int t=0; t<T; t++) {
            String[] inpt = br.readLine().split(" " );
            for (int i=0; i<3; i++) k[i] = Integer.parseInt(inpt[i]);
            for (int i=0; i<3; i++) s[i] = Integer.parseInt(inpt[i+3]);
            
            double d = Math.sqrt(Math.pow(k[0] - s[0], 2) + Math.pow(k[1] - s[1], 2));

            if (k[0] == s[0] && k[1] == s[1] && k[2] == s[2]) System.out.println(-1);
            else if (d > k[2] + s[2] || d < Math.abs(k[2] - s[2])) System.out.println(0);
            else if (d == k[2] + s[2] || d == Math.abs(k[2]- s[2])) System.out.println(1);
            else System.out.println(2);
        }

        br.close();
    }
}
