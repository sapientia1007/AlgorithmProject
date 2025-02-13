import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int mod = 900528;

        String alphabet =  br.readLine();
        String password = br.readLine();

        int dictSize = alphabet.length();

        // 문자를 숫자로 변환하여 저장
        int[] charToIndex = new int[128];
        for (int i=0; i<dictSize; i++) {
            charToIndex[alphabet.charAt(i)] = i+1;  // 알파벳 문자에 대해 인덱스를 저장 (0*방지하고자 +1)
        }

        long cnt = 0;
        for (int i=0; i<password.length(); i++) {
            // 진법 변환 계산
            cnt = (cnt * dictSize + charToIndex[password.charAt(i)]) % mod;
        }

        System.out.println(cnt);
        br.close();
    }
}