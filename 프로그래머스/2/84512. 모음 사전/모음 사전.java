import java.util.*;
import java.io.*;

class Solution {
    public int solution(String word) {
        int answer = 0; 
        ArrayList<String> dictionary = new ArrayList<>(); // 가능한 모든 단어를 저장할 리스트
        String[] vowels = new String[] {"A", "E", "I", "O", "U"}; // 모음 배열

        // 모든 가능한 단어 생성
        generateWords("", 0, dictionary, vowels);

        // 생성된 단어 리스트에서 주어진 단어의 위치를 찾기
        for (int i = 0; i < dictionary.size(); i++) {
            if (word.equals(dictionary.get(i))) {
                answer = i; 
                break;
            }
        }

        return answer; 
    }

    private void generateWords(String currentWord, int currentLength, ArrayList<String> dictionary, String[] vowels) {
        dictionary.add(currentWord); // 현재까지 생성된 단어를 리스트에 추가
        if (currentLength == 5) return; 

        // 모음 배열을 순회하며 새로운 단어를 재귀적으로 생성
        for (int i = 0; i < vowels.length; i++) {
            generateWords(currentWord + vowels[i], currentLength + 1, dictionary, vowels);
        }
    }
}
