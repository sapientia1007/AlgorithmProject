import java.util.*;

/*
array
command => command.length동안 수행
command [i,j,k] => i번째부터 j까지 잘라서 정렬 후 k번째 숫자 리턴하여 결과 배열 추가
*/
class Solution {
        public int[] solution(int[] array, int[][] commands) {
            int[] answer = {};
            answer = new int[commands.length];

            for (int q=0; q<commands.length; q++){
                int[] singleCmd = commands[q];
                int i = singleCmd[0]; int j = singleCmd[1]; int k = singleCmd[2];

                // 인덱스로 copy slice
                int[] resList = Arrays.copyOfRange(array, i-1, j);
                Arrays.sort(resList);
                answer[q] = resList[k-1];
            }
            return answer;
        }
    }