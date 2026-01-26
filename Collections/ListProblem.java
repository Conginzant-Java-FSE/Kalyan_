import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListProblem{
    public static void main(String[] args){
        int[] ratings = {9,10,12,8,-1,7,11,10,6};
        List<Integer> Ratings = new ArrayList<>();

        for(int rating : ratings) {
            if(rating >=1 && rating<=10){
                Ratings.add(rating);
            }
        }

        if(Ratings.isEmpty()){
            System.out.println("No Ratings");
            return;
        }

        Collections.sort(Ratings);

        int sum = 0;
        for(int rating : Ratings ){
            sum += rating;
        }

        double average = sum / Ratings.size();
        int highest = Collections.max(Ratings);
        int lowest = Collections.min(Ratings);


        System.out.println("Cleaned Ratings: " + Ratings);
        System.out.println("Highest Ratings: " + highest);
        System.out.println("Lowest Rating : " + lowest);
        System.out.println("Average Rating :" + average);




    }
}
