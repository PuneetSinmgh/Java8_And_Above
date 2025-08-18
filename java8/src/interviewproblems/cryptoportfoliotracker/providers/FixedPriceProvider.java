package java8.src.interviewproblems.cryptoportfoliotracker.providers;

import java.util.Map;

public class FixedPriceProvider implements PriceProvider{

    Map<String , Double> priceMap;

    FixedPriceProvider(Map<String , Double> map){
        this.priceMap = map;
    }


    @Override
    public double getPrice(String symbol) {
        if ( priceMap.containsKey(symbol))
            return priceMap.get(symbol);

        return 0.0;
    }
}
