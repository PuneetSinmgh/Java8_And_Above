package java8.src.streamapi;

import java.util.List;

public class Test {

    public static void main(String[] args) {


        // Input: [1,4,20,3,10,5]
        // print left and  right index
        // find contigous subarray : sum of elemnt should be k

        List<Integer> ls = List.of(1,4,20,3,10,5);
        ls.stream().mapToInt(Integer::valueOf)
                .average().getAsDouble();

    }
}
