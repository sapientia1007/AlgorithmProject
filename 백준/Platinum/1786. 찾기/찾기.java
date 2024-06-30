import java.io.*;
import java.util.*;

/**
 * 입력 :
 * 		T = 전체 문자열
 * 		P = T 문자열에서 찾을 문자열
 *
 * 	출력 :
 * 		T 문자열 중 P가 나타나는 횟수
 * 		T 문자열 중 P가 나타나는 인덱스 값의 전체를 공백으로 구분
 *
 * 	처리 :
 * 		kmp
 */
// 풀기
public class Main{
	static String T; static String P;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = br.readLine();
		P = br.readLine();
		
		int[] F = new int[P.length()]; // 패턴 길이만큼의 실패 함수 배열 생성
		
		for (int t=1, p=0 ; t<P.length(); t++) {
			while (p>0 && P.charAt(t) != P.charAt(p)) p=F[p-1]; // 일치하지 않으면 이전 접두사로
			if (P.charAt(t) == P.charAt(p)) F[t] = ++p; // 일치하면 접두사 길이 저장
		}
		
		List<Integer> ans = new ArrayList<>();
		for (int t=0, p=0 ; t<T.length(); t++) {
			while (p>0 && T.charAt(t) != P.charAt(p)) p=F[p-1]; // 일치하지 않으면 이전 접두사로
			if (T.charAt(t) == P.charAt(p)) {
				if (p==P.length()-1) { // 패턴 전체가 일치하면
					ans.add((t-p+1)); // 시작 위치를 추가
					p=F[p]; // 다음 검색을 위해 접두사 길이로 이동
				} else {
					p++; // 일치하면 다음 문자로 이동
				}
			}
		}
	
		System.out.println(ans.size());
		for(int i : ans) System.out.print(i + " ");
		br.close();
	}
}
