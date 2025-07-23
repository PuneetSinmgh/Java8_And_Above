package java8.src.RealWorldInterview.TimeBasedCache.Cache;

import java.util.Optional;

public class TimeBasedCacheLinkedHMImplementation implements TimeBasedCache {

    @Override
    public Optional<Integer> get(Integer key) {
        return Optional.empty();
    }

    @Override
    public void set(Integer key, Integer value, Long expiryTimeMillis) {

    }
}
