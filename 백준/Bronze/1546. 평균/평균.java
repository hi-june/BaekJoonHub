import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<Integer> scores = Arrays.stream(br.readLine().split(" "))
            .map(Integer::valueOf)
            .collect(Collectors.toList());

        int m = Collections.max(scores);

        int sum = 0;
        for (int s : scores) {
            sum += s;
        }

        double newSum = (double) sum / m * 100;
        double answer = newSum / scores.size();

        System.out.println(answer);
    }
}