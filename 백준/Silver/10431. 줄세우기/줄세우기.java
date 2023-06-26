import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int P = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < P; i++) {
            int steps = 0;
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            
            int[] students = new int[20];
            for (int j = 0; j < 20; j++) {
                students[j] = Integer.parseInt(st.nextToken());
            }
            
            List<Integer> studentsRow = new ArrayList<>();
            
            for (int height : students) {
                int idx = getIdx(studentsRow, height);
                
                if (idx == -1) {
                    studentsRow.add(height);
                } else {
                    steps += studentsRow.size() - idx;
                    studentsRow.add(idx, height);
                }
            }
            
            bw.write(num + " " + steps + "\n");
        }
        
        bw.flush();
        bw.close();
        
        br.close();
    }
    
    public static int getIdx(List<Integer> studentsRow, int height) {
        for (int h : studentsRow) {
            if (h > height) {
                int idx = studentsRow.indexOf(h);
                
                return idx;
            }
        }
        
        return -1;
    }
}