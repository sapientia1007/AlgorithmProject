import java.util.Arrays;

class Solution {
        public String solution(int[] numbers) {
            String answer = "";
            StringBuilder sb = new StringBuilder();
            String[] answerLst = new String[numbers.length];
            for (int i=0; i<numbers.length; i++) {
                answerLst[i] = String.valueOf(numbers[i]);
            }

            Arrays.sort(answerLst, (n1, n2) -> (n2+n1).compareTo(n1+n2)); // 두 숫자를 문자열로 붙인 결과를 비교하여 정렬

            if (answerLst[0].equals("0")) return "0"; // 첫번째 요소가 0이면, 모든 요소가 0이므로 최종적으로 0

            for (String number : answerLst) sb.append(number);
            answer = String.valueOf(sb);
            return answer;
        }
}