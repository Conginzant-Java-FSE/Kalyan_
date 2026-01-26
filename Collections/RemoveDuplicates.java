import java.util.*;

public class RemoveDuplicates {

    public static List<Integer> removeDuplicates(List<Integer> list) {
        Set<Integer> set = new LinkedHashSet<>(list);
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 10, 30, 20, 40);
        List<Integer> result = removeDuplicates(numbers);
        System.out.println(result);
    }
}
