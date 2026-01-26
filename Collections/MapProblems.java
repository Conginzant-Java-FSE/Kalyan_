import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapProblem {
    public static void main(String[] args){

        Map<String, Integer> currentStock = new HashMap<>();
        currentStock.put("MacBook", 5);
        currentStock.put("Iphone", 10);
        currentStock.put("AirPods", 25);

        Map<String, Integer> IncomingStock = new HashMap<>();
        IncomingStock.put("Iphone", 5);
        IncomingStock.put("AirPods", 5);
        IncomingStock.put("VisionPro", 2);

        for (Map.Entry<String, Integer> entry : IncomingStock.entrySet()){
            String product = entry.getKey();
            int quantity = entry.getValue();

            currentStock.put(product, currentStock.getOrDefault(product, 0) + quantity);
        }

        Map<String, Integer> sortedstock = new TreeMap<>(currentStock);

        int totalunits = 0;
        for (int qty : sortedstock.values()){
            totalunits += qty;
        }

        System.out.println("Updated Stock :");
        for(Map.Entry<String, Integer> entry : sortedstock.entrySet()){
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("Total Unit in store : " + totalunits);
    }
}
