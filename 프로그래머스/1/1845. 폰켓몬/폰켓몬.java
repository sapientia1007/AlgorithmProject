import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] nums) {
            int maxNum = nums.length/2; // 최대로 가져갈 수 있는 폰켓몬 수

            HashSet<Integer> ponketmon = new HashSet<>();
            for (int n : nums) {
                ponketmon.add(n); // 중복 제거한 총 폰켓몬 종류
            }
            if (maxNum > ponketmon.size()) return  ponketmon.size(); // 최대로 가져갈 수 있는 수가 중복 제거한 폰켓몬 종류보다 크다 -> 그만큼의 폰켓몬이 없다 -> 중복 제거한 폰켓몬 리턴
            else return maxNum;
        }
}