import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Double> drinks = Arrays.stream(br.readLine().split(" "))
                .map(Double::valueOf)
                .collect(Collectors.toList());

        Double max = Collections.max(drinks);
        drinks.remove(max);

        double total = max;

        for (double i : drinks) {
            total += (i / 2);
        }

        System.out.println(total);
    }
}