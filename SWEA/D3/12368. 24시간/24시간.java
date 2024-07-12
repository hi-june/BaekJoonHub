import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
            int total = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sum();
            
            bw.write(String.format("#%d %d\n", test_case, total % 24));
		}
        
        bw.flush();
        bw.close();
        
        br.close();
	}
}