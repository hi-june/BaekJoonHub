import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++) {
            int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
            int L = inputs[0];
            int U = inputs[1];
            int X = inputs[2];
           
            if (X < L) {
                bw.write(String.format("#%d %d\n", test_case, L - X));
            } else if (X <= U) {
                bw.write(String.format("#%d %d\n", test_case, 0));
            } else {
                bw.write(String.format("#%d %d\n", test_case, -1));
            }
        }

        bw.flush();
        bw.close();
        br.close();
	}
}