import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<T; i++) {
			String cmdStr = br.readLine();
			Stack<Character> front = new Stack<Character>();
			Stack<Character> back = new Stack<Character>();
			for (int j=0; j<cmdStr.length(); j++) {
				char pos = cmdStr.charAt(j);
				if(pos=='<') {
					if (!front.isEmpty()) {
						back.push(front.pop());
					}
				}	else if (pos == '>' ) {
						if (!back.isEmpty()) {
							front.push(back.pop());
						}
					} else if (pos =='-') {
						if (!front.isEmpty()) {
							front.pop();
						}
					} else {
						front.push(cmdStr.charAt(j));
					}
				}
			while (!back.isEmpty()) {
				front.push(back.pop());
			}
			for (int k=0; k<front.size(); k++) {
				bw.write(front.get(k));
				}
			bw.write("\n");
			}
		bw.flush();
		br.close();
	}
}	
