import java.util.*;

public class Main {
    public static void main(String[] args) {        
        Scanner sc = new Scanner(System.in);

        String digit = sc.next();
        int count0 = 0; 
        int count1 = 0;
        
        if (digit.charAt(0) == '1') {
            count0 += 1;
        }
        else {
            count1 += 1;
        }

        for (int i = 0; i < digit.length() - 1; i++) {
            if (digit.charAt(i) != digit.charAt(i + 1)) {
                if (digit.charAt(i + 1) == '1') 
                    count0 += 1;
                else 
                    count1 += 1;
            }
        }

        System.out.println(Math.min(count0, count1));
    }
}