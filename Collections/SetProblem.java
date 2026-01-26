import java.util.HashSet;
import java.util.Set;

public class SetProblem {
    public static void main(String[] args){
        String[] names = {"John","Aisha","Ravi","John","Mina","Ravi","Aisha","Tom"};
        Set<String> name = new HashSet<>();

        int dupCount = 0;

        for (String name1 : names){
            if(!name.add(name1)){
                dupCount++;
            }
        }

        System.out.println("Unique Applicants :" + name);
        System.out.println("Duplicated Removed :" + dupCount);

    }
    
}
