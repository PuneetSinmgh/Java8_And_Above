package java8.src.RealWorldInterview.TimeBasedCache.Cache;

import java.util.Optional;

public interface TimeBasedCache {

    public Optional<Integer> get(Integer key) ;
    public void set(Integer key, Integer value, Long expiryTimeMillis) ;

}
