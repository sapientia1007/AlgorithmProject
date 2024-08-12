class Solution {
        public String solution(String number, int k) {
//            String answer = "";
            StringBuilder answer = new StringBuilder();
            int numLen = number.length() - k; // 만들어야 할 숫자 길이
            int idx = 0;

            while (answer.length() < numLen) {
                char maxNum = '0';
                int endIdx = number.length() - numLen + answer.length();
                int maxIdx = idx;

                for (int i = idx; i <= endIdx; i++) {
                    char currentChar = number.charAt(i);
                    if (currentChar > maxNum) {
                        maxNum = currentChar;
                        maxIdx = i;
                    }
                }

                answer.append(maxNum);
                idx = maxIdx + 1;
                k-=1;
            }

            return answer.toString();
        }
    }
