import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<List<Integer>> schedule = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> room = Arrays.stream(br.readLine().split(" "))
                                        .map(Integer::valueOf)
                                        .collect(Collectors.toList());
            schedule.add(room);
        }

        schedule.sort((i1, i2) -> {
            if (i1.get(1) - i2.get(1) == 0)
                return i1.get(0) - i2.get(0);
            return i1.get(1) - i2.get(1);
        });

        int chosen_end_time = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (chosen_end_time > schedule.get(i).get(0))
                continue;

            chosen_end_time = schedule.get(i).get(1);
            count += 1;
        }

        System.out.println(count);
    }
}