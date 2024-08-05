import java.util.*;

class Solution {
        static HashSet<Integer> numberLst;

        public int solution(String numbers) {
            int answer = 0;

            // 수의 조합을 담을 배열 (중복 제거)
            numberLst = new HashSet<>();
            permNumber("", numbers);

            for (int n : numberLst) {
                if (checkNumber(n)) answer ++;
            }
            return answer;
        }
    
    // 수 조합 생성 메서드
    public static void permNumber(String prefix, String remaining) {
        int n = remaining.length();
        if (!prefix.equals("")) {
            numberLst.add(Integer.valueOf(prefix));
        }
        for (int i = 0; i < n; i++) {
            permNumber(prefix + remaining.charAt(i), remaining.substring(0, i) + remaining.substring(i + 1, n));
        }

    }
    // 소수인지 확인
    static boolean checkNumber(int num) {
        if (num <= 1) return false; // 1 이하는 소수가 아님
        if (num == 2) return true; // 2는 소수
        if (num % 2 == 0) return false; // 2를 제외한 짝수는 소수가 아님
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) return false;
        }
        return true;
    }
}