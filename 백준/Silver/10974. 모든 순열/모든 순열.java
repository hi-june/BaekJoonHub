import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = IntStream.range(1, n + 1).toArray();

        permutation(arr, new int[n], new boolean[arr.length], 0, n);
    }

    public static void permutation(int[] source, int[] dest, boolean[] visited, int depth, int r) {
        if(depth == r){
            String line = Arrays.stream(dest)
                    .mapToObj(i -> String.valueOf(i))
                    .collect(Collectors.joining(" "));
            System.out.println(line);
            return;
        }
        for (int i = 0; i < source.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dest[depth] = source[i];
                permutation(source, dest, visited, depth + 1, r);
                visited[i] = false;
            }
        }
    }
}