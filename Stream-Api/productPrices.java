import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class productPrices {
    public static void main(String[] args){
        List<Integer> prices = List.of(
                500, 1200, 2500, 1200, 3000, 800, 2500
        );

        List<Integer> li1 = prices.stream()
                .filter(amount -> amount > 1000)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .filter(pri -> pri > 2000)
                .collect(Collectors.toList());

        System.out.println(" Processed Prices: " + li1);
        System.out.println("Count of prices > 2000 : " + li1.stream().count());
    }
}
