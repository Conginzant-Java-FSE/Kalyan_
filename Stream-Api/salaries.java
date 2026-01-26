import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//import static java.util.stream.Nodes.collect;

public class salaries {
    public static void main(String[] args){
        List<String> employees = List.of(
                "Alice:60000",
                "Bob:45000",
                "Charlie:75000",
                "David:60000",
                "Eva:90000"
        );

        List<Integer> employess1 = employees.stream()
                .map(item -> item.split(":"))
                .map(parts -> Integer.parseInt(parts[1]))
                .filter(salary -> salary >  50000)
                .map(n -> n *12)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .limit(2)
                .collect(Collectors.toList()
                );







        System.out.println("Annual Salaries After Processing: " + employess1);
        System.out.println("Count :" + employess1.stream().count());


    }
}
