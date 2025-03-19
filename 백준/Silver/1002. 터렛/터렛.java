import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t=0; t<T; t++) { 
            int[] k = new int[3]; int[] b = new int[3];

            String[] inpt = br.readLine().split(" ");

            for (int i=0; i<3; i++) k[i] = Integer.parseInt(inpt[i]);
            for (int j=0; j<3; j++) b[j] = Integer.parseInt(inpt[j+3]);

            // 거리
            double d = Math.sqrt(Math.pow(k[0]-b[0], 2) + Math.pow(k[1]-b[1], 2));

            if (k[0] == b[0] && k[1] == b[1] && k[2] == b[2]) {
                System.out.println(-1);
            } else if (d > k[2] + b[2] || d < Math.abs(k[2] - b[2])) {
                System.out.println(0);
            } else if (d == k[2] + b[2] || d == Math.abs(k[2] - b[2])) {
                System.out.println(1);
            } else {
                System.out.println(2);
            }
        }

        br.close();
    }
}