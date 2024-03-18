import java.util.*;
import java.text.*;

public class Main {
    public static void main(String[] args) {
        Date date = new Date();
		DateFormat df = new SimpleDateFormat("YYYY-MM-dd");
		df.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));

        System.out.println(df.format(date));
    }
}