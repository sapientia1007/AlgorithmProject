import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> players = new HashMap<>();
        // 참가자 수 누적 (동명이인 존재)
        for (int i = 0; i<participant.length; i++) {
            if (players.containsKey(participant[i])) players.put(participant[i], players.get(participant[i])+1);
            else players.put(participant[i], 1);
        }
        // 완주자 감소 -> 해당 이름의 참가자가 모두 완주했다면 HashMap에서 제거
        for (int i=0; i<completion.length; i++){
            players.put(completion[i], players.get(completion[i])-1);
            if (players.get(completion[i])==0) players.remove(completion[i]);
        }
        // 최종 결과 출력
        for (String name : players.keySet()) answer += name;
        return answer;
    }
}