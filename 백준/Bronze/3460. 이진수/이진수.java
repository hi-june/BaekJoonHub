import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            int n = Integer.parseInt(br.readLine());
            List<Integer> digit = new ArrayList<>();

            while (n != 1) {
                digit.add(n % 2);
                n = n / 2;
            }
            digit.add(n);

            String answer = "";
            for (int j = 0; j < digit.size(); j++) {
                if (digit.get(j) == 1) {
                    answer += j + " ";
                }
            }
            bw.write(answer.substring(0, answer.length() - 1) + "\n");
        }
        bw.flush();
        bw.close();
    }
}
