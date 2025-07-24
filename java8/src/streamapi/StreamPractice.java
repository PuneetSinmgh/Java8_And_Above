package java8.src.streamapi;

// Java Stream API Practice
import java.util.*;
import java.util.function.Function;
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

        // mapping problems

        List<User> users = List.of(
                new User("Alice", 30),
                new User("Bob", 25),
                new User("Charlie", 35)
        );
        // Convert to: Map<String, Integer> nameToAge
        Map<String, Integer> nameToAge = users.stream().collect(Collectors.toMap(u-> u.name, u-> u.age));

        // count occurances of words
        List<String> words = List.of("apple", "banana", "apple", "orange", "banana", "apple");
        Map<String, Long> wordCounts = words.stream().collect( Collectors.groupingBy( Function.identity(), Collectors.counting()));

        Map<String, Integer> productPrices = Map.of(
                "Book", 120,
                "Pen", 15,
                "Bag", 200,
                "Pencil", 10
        );
        // return a new map with only products that cost more than 100.
        Map<String, Integer> filterredProducts = productPrices.entrySet().stream().filter( e-> e.getValue() > 100).collect(Collectors.toMap(e-> e.getKey(), e -> e.getValue()));
        // Output: {"Book"=120, "Bag"=200}


        // sorting a map by values in descending order?
        Map<String, Integer> scores = Map.of(
                "Alice", 85,
                "Bob", 95,
                "Charlie", 80
        );

        scores = scores.entrySet().stream().
                sorted( Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry:: getValue,
                        (e1,e2) -> e1,
                        LinkedHashMap::new
                ));

    // Output: LinkedHashMap<String, Integer> sorted by score descending

    }

    // 1️⃣ Return a list of strings that start with the letter 'A' (case-insensitive)
    public static List<String> filterStringsStartingWithA(List<String> input) {

        return input.stream().map(String::toLowerCase).filter( s -> s.startsWith("A")).toList();
    }

    // 2️⃣ Given a list of integers, return the square of each number, sorted in descending order
    public static List<Integer> squareAndSortDescending(List<Integer> numbers) {
        // Your code here
        return numbers.stream().map(n-> n*n).sorted(Collections.reverseOrder()).toList();
    }

    // 3️⃣ Count how many strings in the list have length greater than 5
    public static long countLongStrings(List<String> words) {
        // Your code here
        return words.stream().filter(s -> s.length() > 5).count();
    }

    // 4️⃣ Given a list of words, return a map of word to its length
    public static Map<String, Integer> mapWordToLength(List<String> words) {
        // Your code here
        //words.stream().map( s -> Map.entry(s, s.length())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return words.stream().collect(Collectors.toMap(Function.identity(), String::length));
    }

    // 5️⃣ Flatten a list of list of integers and return a list of unique sorted values
    public static List<Integer> flattenAndDeduplicate(List<List<Integer>> nestedList) {
        // Your code here

        return nestedList.stream().flatMap(List::stream).distinct().sorted().toList();
    }

}

class User {
    String name;
    int age;

    User(String name, int age) { this.name = name; this.age = age; }
}

