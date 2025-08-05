package java8.src.streamapi.minidomain.app;

import java8.src.streamapi.minidomain.model.Address;
import java8.src.streamapi.minidomain.model.Order;
import java8.src.streamapi.minidomain.model.OrderItem;
import java8.src.streamapi.minidomain.model.Person;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SortingAndSearchingPerson {

    record PersonTotal(String id, String name, double total) {
        @Override
        public boolean equals(Object o) {
            if (!(o instanceof PersonTotal that)) return false;
            return Double.compare(total, that.total) == 0 && Objects.equals(id, that.id) && Objects.equals(name, that.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name, total);
        }
    }

    public static void main(String[] args) {

        List<Person> people = List.of(
                // Alice: 2 orders, one with multiple items
                new Person("U1","Alice", LocalDate.of(1998, 1, 5),
                        new Address("San Jose","US"),
                        List.of(
                                new Order("O100", LocalDate.of(2025, 7, 1),
                                        List.of(
                                                new OrderItem("S-1", "Headphones", 1, 79.99, List.of("electronics","audio")),
                                                new OrderItem("S-2", "USB-C Cable", 3, 9.99, List.of("electronics","accessories"))
                                        )
                                ),
                                new Order("O101", LocalDate.of(2025, 7, 20),
                                        List.of(new OrderItem("S-3", "Notebook", 2, 4.50, List.of("stationery")))
                                )
                        )
                ),
                // Bob: 1 order
                new Person("U2","Bob", LocalDate.of(1995, 11, 30),
                        new Address("Austin","US"),
                        List.of(
                                new Order("O200", LocalDate.of(2025, 6, 28),
                                        List.of(new OrderItem("S-1", "Headphones", 2, 75.00, List.of("electronics","audio")))
                                )
                        )
                ),
                // Carol: no orders
                new Person("U3","Carol", LocalDate.of(2001, 3, 12),
                        new Address("Toronto","CA"),
                        List.of()
                )
        );
        // find all person for given country sorted by name
        System.out.println("Person from US sorted by name");
        findPeopleByCountrySortedByName(people, "US")
                .forEach(person -> System.out.println(person.getName()+" "));

        System.out.println("Person sorted DOB in Ascending Order");
        List<Person> sortedPeople = sortPeopleByYoungestFirst(people);
        sortedPeople.forEach( p -> System.out.println( p.getName()+" "));

        // List top N OrderIds of all the Persons
        System.out.println("top N Most Recent OrderIds of all the Persons");
        List<String> orderIds = topNRecentOrderIds(people, 5);
        orderIds.forEach(o -> System.out.println( o +" "));

        // List SKU ever sold
        System.out.println("List of SKUs sold");
        List<String> skuList = allUniqueSkus(people);
        skuList.forEach(o -> System.out.println( o +" "));

        // List of PersonTotal i.e  spend per person, sort by spend DESC
        System.out.println("List of PersonTotal i.e  spend per person, sort by spend DESC");
        List<PersonTotal>  personTotalList = rankByTotalSpend( people);
        personTotalList.forEach(pt -> System.out.println( pt.name() +" "));
    }

    public static List<Person> findPeopleByCountrySortedByName(List<Person> people, String country){
        // find all person for given country sorted by name
        return people.stream().filter(p -> p.getAddress().getCountry().equals(country))
                .sorted( Comparator.comparing(Person::getName)).toList();
    }

    public static List<Person> sortPeopleByYoungestFirst(List<Person> people){
        // sort by date of birth
        return people.stream().sorted(Comparator.comparing(Person::getDob).reversed()).toList();
    }

    public static List<String> topNRecentOrderIds(List<Person> people, int n){
        // top N orderIds for all people , get all orders in one stream , sort by placed date , then top n sorder order,
        return people.parallelStream().flatMap( p -> p.getOrders().stream())
                .sorted(Comparator.comparing(Order::getPlacedAt).reversed())
                .limit(n)
                .map(Order::getOrderId).toList();
    }

    // Find all unique SKUs ever purchased
    public static List<String> allUniqueSkus(List<Person> people){
        return people.stream().flatMap(p -> p.getOrders().stream())
                .flatMap(order -> order.getItems().stream())
                .map(OrderItem::getSku).distinct().toList();
    }

    // Total spend per person, sort by spend DESC
    public static List<PersonTotal> rankByTotalSpend(List<Person> people){
        // calculate total spend of the
        return people.stream()
                .collect(Collectors.toMap(Function.identity(), p -> p.getOrders().stream().flatMap(order -> order.getItems().stream()).toList() ))
                .entrySet().stream()
                .map( e-> {
                    // calculate total value
                    double total = e.getValue().stream()
                            .mapToDouble(item -> item.getQuantity()*item.getUnitPrice()).sum();
                    return new PersonTotal(e.getKey().getId(), e.getKey().getName(), total);
                }).sorted().toList();
    }

}
