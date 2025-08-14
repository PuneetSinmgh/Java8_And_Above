package java8.src.collection.Hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Travel{
    String startSt;
    int startTime;

    Travel(  String stationName, int t){
        startSt = stationName;
        startTime = t;
    }
}

class TravelInfo{
    double totalTime;
    int count;
    String stationName;

    TravelInfo(String stationName){
        stationName = stationName;
    }
}

public class UndergroundSystem {

    Map<Integer, Travel> trafficMap ;
    Map<String, List<Integer>> travalTimeMap;

    public UndergroundSystem() {

        trafficMap = new HashMap();
        travalTimeMap = new HashMap();
    }

    public void checkIn(int id, String stationName, int t) {

        if ( !trafficMap.containsKey(id) ){
            trafficMap.put( id , new Travel(stationName, t));
        }
    }

    public void checkOut(int id, String stationName, int t) {

        if ( trafficMap.containsKey(id) ){
            Travel tl = trafficMap.get(id);
            List<Integer> ls = travalTimeMap.getOrDefault( tl.startSt+"-"+stationName , new ArrayList() );
            ls.add(t - tl.startTime );
            travalTimeMap.put(tl.startSt+"-"+stationName , ls );
            trafficMap.remove(id);
        }
    }

    public double getAverageTime(String startStation, String endStation) {

        String key = startStation+"-"+endStation;
        if ( travalTimeMap.containsKey(key )){

            List<Integer> ls = travalTimeMap.get(key);

            return ls.stream().mapToInt(Integer::valueOf)
                    .average().getAsDouble();
        }

        return 0.0;
    }
}