import java.util.*;

class Solution {
        public int solution(int n, int[] lost, int[] reserve) {
            int answer = 0;
            int[] clothes = new int[n+1];
            Arrays.fill(clothes, 1); clothes[0]=0;
            for (int idx : reserve) clothes[idx] += 1;
            for (int idx : lost) clothes[idx] -=1;

            for (int i=1; i<=n; i++) {
                if (clothes[i] == 0) {
                    if (i-1 >= 1 && clothes[i-1] == 2){
                        clothes[i-1]-=1;
                        clothes[i]+=1;
                    } else if (i+1 <=n && clothes[i+1] == 2){
                        clothes[i+1]-=1;
                        clothes[i]+=1;
                    }
                }
            }

            for (int i=1; i<=n; i++){
                if (clothes[i] > 0) answer++;
            }
            return answer;
        }
    }
