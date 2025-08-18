package java8.src.interviewproblems.cryptoportfoliotracker.providers;

// this interface follows Open/Closed principle
public interface PriceProvider {

    public double getPrice(String symbol);
}
