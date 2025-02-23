import java.util.*;
import java.io.*;

class Solution {
    public int answer;
    public boolean[] visitedDungeons; // 방문 여부
    
    public int solution(int initialFatigue, int[][] dungeons) {
        answer = -1;
        visitedDungeons = new boolean[dungeons.length]; // 던전 방문 여부 배열 초기화
        exploreDungeons(0, initialFatigue, dungeons); 
        return answer;
    }

    public void exploreDungeons(int clearedCount, int currentFatigue, int[][] dungeons) {
        for (int i = 0; i < dungeons.length; i++) {
            // 던전을 방문하지 않았고, 현재 피로도가 해당 던전의 최소 요구 피로도 이상인 경우
            if (!visitedDungeons[i] && currentFatigue >= dungeons[i][0]) {
                visitedDungeons[i] = true; 
                exploreDungeons(clearedCount + 1, currentFatigue - dungeons[i][1], dungeons); // 재귀 호출로 다음 던전 탐험
                visitedDungeons[i] = false; 
            }
        }
        // 현재까지 클리어한 던전 수와 최대 클리어 수를 비교하여 갱신
        answer = Math.max(answer, clearedCount);
    }
}
