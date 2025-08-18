package java8.src.interviewproblems.cryptoportfoliotracker.assets;

import java8.src.interviewproblems.cryptoportfoliotracker.providers.PriceProvider;

public class CryptoAsset extends ParentAsset implements Asset{
    @Override
    public String getSymbol() {
        return "";
    }

    @Override
    public double getQuantity() {
        return 0;
    }

    @Override
    public double getValueInUSD(PriceProvider provider) {
        return 0;
    }
}
