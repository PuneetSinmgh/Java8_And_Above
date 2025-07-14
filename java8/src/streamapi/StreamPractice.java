package java8.src.streamapi;

// Java Stream API Practice
import java.util.*;
import java.util.stream.*;

public class StreamPractice {
    public static void main(String[] args) {
        // Problem 1: Find all even numbers and print them
        List<Integer> l = List.of(1,2,3,5,6,3,7,8,4,3,7,8,12,45,76,34);
        l.stream().filter(x -> x%2==0).forEach(System.out::println);

        // Problem 2: Convert list of strings to uppercase and collect into a new list.
        List<String> strs = List.of("Abc", "skd","rl","arr","wer","dvf");
        List<String> strs2 = strs.stream().map(String::toLowerCase).collect(Collectors.toList());
        System.out.println(strs);
        System.out.println(strs2);

        // Problem 3: Count strings starting with 'A'
        int count = Math.toIntExact(strs2.stream().filter(s -> s.startsWith("a")).count());
        System.out.println(count);

        // Problem 4: Sort list of integers in descending order
         l = l.stream().sorted().toList();
        System.out.println(l);

        // Problem 5: Sum of numbers greater than 10
        int sum = l.stream().filter(x -> x>10 ).mapToInt(Integer::intValue).sum();
        System.out.println(sum);
    }
}
