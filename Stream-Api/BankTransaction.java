import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BankTranscation {
    public static void main(String[] args){
        List<String> transactions = List.of(
                "TXN1001:SAVINGS:12000",
                "TXN1002:CURRENT:15000",
                "TXN1003:SAVINGS:20000",
                "TXN1004:SAVINGS:12000",
                "TXN1005:SAVINGS:8000",
                "TXN1006:CURRENT:30000"
        );

        List<Integer> li1 = transactions.stream()
                .map(txn -> txn.split(":"))
                .filter(parts -> parts[1].equals("SAVINGS"))
                .map(parts -> Integer.parseInt(parts[2]))
                .filter(amo -> amo>= 10000)
                .map(am -> am + (am * 18 /100))
                .distinct()
                .sorted(Comparator.reverseOrder())
                .filter(amt -> amt>=20000)
                .limit(2)
                .collect(Collectors.toList());



        System.out.println(" Processed Amounts: " + li1);
        System.out.println("Count of amounts > 20000:" + li1.stream().count());
    }
}
