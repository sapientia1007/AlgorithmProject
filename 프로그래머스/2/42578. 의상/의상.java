import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> clothHash = new HashMap<>();

        // 배열 저장 (각 종류별 갯수 저장)
        for (int i=0; i<clothes.length; i++) {
            String clothType = clothes[i][1];
            String clothName = clothes[i][0];
            if (clothHash.containsKey(clothType)) clothHash.put(clothType, clothHash.get(clothType) + 1);
            else clothHash.put(clothType, 1);
        }

        // 조합
        int answer =1;
        for (int i: clothHash.values()) answer *= (i+1); 

        return answer-1; // 아무것도 안 입은 경우 제외
    }
    }
