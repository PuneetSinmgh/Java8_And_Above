package java8.src.interviewproblems.cryptoportfoliotracker.portfolio;

import java8.src.interviewproblems.cryptoportfoliotracker.assets.Asset;
import java8.src.interviewproblems.cryptoportfoliotracker.providers.PriceProvider;

import java.util.ArrayList;
import java.util.List;

public class Portfolio {

    private List<Asset> assets;

    Portfolio(){
        new ArrayList<>();
    }
    // Dependency Inversion
    // Depend on abstractions, not on concretions.
    // extensible as it doesnot depend on concreate implementaiton
    public void addAsset(Asset asset){
        assets.add(asset);
    }

    // extensible as it doesnot depend on concreate implementaiton of price provider
    public double getTotalValue(PriceProvider provider){

        return assets.stream().map( a -> provider.getPrice(a.getSymbol()))
                .mapToDouble(Double::valueOf).sum();

    }

}
