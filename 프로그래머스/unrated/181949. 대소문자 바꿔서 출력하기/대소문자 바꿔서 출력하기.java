import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String input = br.readLine();
        char[] charArray = input.toCharArray();
        
        StringBuilder sb = new StringBuilder();
        for (char c : charArray) {
            if (Character.isUpperCase(c)) {
                sb.append(String.valueOf(c).toLowerCase());
            } else if (Character.isLowerCase(c)) {
                sb.append(String.valueOf(c).toUpperCase());
            }
        }
        
        System.out.println(sb);
    }
}