import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        
        for (int i = 1; i <= 9; i++) {
            System.out.println(String.format("%d * %d = %d", n, i, n*i));
        }
    }
}