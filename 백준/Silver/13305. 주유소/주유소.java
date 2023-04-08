import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Integer> distance = Arrays.stream(br.readLine().split(" "))
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        List<Integer> city = Arrays.stream(br.readLine().split(" "))
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        List<Integer> cityPoint = new ArrayList<>();

        int minCity = Collections.min(city);
        cityPoint.add(minCity);

        while (city.indexOf(minCity) != 0) {
            int newMinCity = Collections.min(city.subList(0, city.indexOf(minCity)));
            minCity = newMinCity;
            cityPoint.add(minCity);
        }

        int cost = 0;
        for (int i = cityPoint.size() - 1; i >= 0; i--) {
            int startIdx, endIdx;

            if (i == 0) {
                startIdx = city.indexOf(cityPoint.get(i));
                endIdx = distance.size();
            } else {
                startIdx = city.indexOf(cityPoint.get(i));
                endIdx = city.indexOf(cityPoint.get(i - 1));
            }

            int distanceSum = 0;
            for (int j = startIdx; j < endIdx; j++) {
                distanceSum += distance.get(j);
            }
            cost += cityPoint.get(i) * distanceSum;
        }

        System.out.println(cost);
    }
}