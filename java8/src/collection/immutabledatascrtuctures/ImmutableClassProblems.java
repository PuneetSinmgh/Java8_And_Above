package java8.src.collection.immutabledatascrtuctures;

import java.util.List;

public class ImmutableClassProblems {

    public static void main(String[] args) {
        // Problem 1: Create an immutable list of strings representing weekdays.
        List<String> weekdays = List.of("Sunday", "Monday", "Tuesday");

        // Problem 2: Define a Record 'Person' with fields 'name' and 'age'.
        record Person(String name , int age){}
    }
}
