package java8.src.interviewproblems.cryptoportfoliotracker.assets;

import java8.src.interviewproblems.cryptoportfoliotracker.providers.PriceProvider;

public interface Asset {

    public String getSymbol();
    public double getQuantity();
    public double getValueInUSD(PriceProvider provider);

}
