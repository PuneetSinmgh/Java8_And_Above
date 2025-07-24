package java8.src.streamapi;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CountLargestGroup {

    public static void main(String[] args) {
        int n = 25;
        System.out.println( countLargestGroup(25));
    }
    public static int countLargestGroup(int n) {

        Map<Integer, Integer> hm = new HashMap();

        for( int i =1 ; i<= n ;i++){
            hm.put( i , hm.getOrDefault( i , 0)+1);

        }
        int maxSize = hm.values().stream().max(Integer::compareTo).get();
        return (int)hm.values().stream().filter( v -> v == maxSize ).count();
    }

    public int sumOfDigit(int n) {
        int sum =0 ;
        while ( n > 0){
            sum += n%10;
            n = n/10;
        }
        return sum;
    }
}
