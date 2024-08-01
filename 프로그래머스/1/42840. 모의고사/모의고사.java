import java.util.*;

class Solution {
        public int[] solution(int[] answers) {
            int[] answer = {};
            int[] st1 = {1, 2, 3, 4, 5}; // 5개씩 반복
            int[] st2 = {2, 1, 2, 3, 2, 4, 2, 5}; // 8개씩 반복
            int[] st3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; // 10개씩 반복

            int[] resArr = new int[3];

            // 1번 수포자
            int cnt1 = 0;
            for (int i = 0; i < answers.length; i++) {
                if (answers[i] == st1[i % st1.length]) {
                    cnt1++;
                }
            }
            resArr[0] = cnt1;

            // 2번 수포자
            int cnt2 = 0;
            for (int i = 0; i < answers.length; i++) {
                if (answers[i] == st2[i % st2.length]) {
                    cnt2++;
                }
            }
            resArr[1] = cnt2;

            // 3번 수포자
            int cnt3 = 0;
            for (int i = 0; i < answers.length; i++) {
                if (answers[i] == st3[i % st3.length]) {
                    cnt3++;
                }
            }
            resArr[2] = cnt3;

            // 가장 많은 정답을 맞힌 수포자를 찾기
            int maxVal = Arrays.stream(resArr).max().getAsInt();
            ArrayList<Integer> answerLst = new ArrayList<>();

            for (int i = 0; i < resArr.length; i++) {
                if (resArr[i] == maxVal) {
                    answerLst.add(i + 1);
                }
            }

            // 배열로 변환
            answer = new int[answerLst.size()];
            for (int i = 0; i < answerLst.size(); i++) {
                answer[i] = answerLst.get(i);
            }
            return answer;
        }
    }
