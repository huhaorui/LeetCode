import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class stream {
    public static void main(String[] args) {
        Map<String, Integer> score = new HashMap<>();
        score.put("201806061100", 95);
        score.put("201806061101", 75);
        score.put("201806061102", 53);
        score.put("201806061103", 54);
        score.put("201806061104", 77);
        List<String> blame = score.keySet().stream()
                .filter(key -> score.get(key) < 60)
                .collect(Collectors.toList());
        System.out.println(blame);
    }
}
