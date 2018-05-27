import java.lang.*;
import java.util.*;
import java.math.*;
import java.util.AbstractMap.SimpleEntry;

public class Main {
    public static void main(String[] arr) {
      
    }
}

class Lru {
  int limit = 5;

  ConcurrentMap<Integer, String> cache = new ConcurrentHashMap<>();
  PriorityBlockingQueue<TsKey> heap = new PriorityBlockingQueue(new Comparator<TsKey> {
        public Integer compare(TsKey k1, TsKey k2){
          return k1.ts > k2.ts;
        }
    });

  void put(int key, String value){
    synchronized {
      if(cache.size() == limit){
        TsKey old = heap.poll();
        cache.remove(old.key);
      }

      cache.put(key, value);
      heap.add(new TsKey(System.currenttimemillis(), key));
    }
  }

  String get(){
    synchronized {
      TsKey old = heap.poll();
      cache.remove(old.key);
    }
  }    
}

class TsKey {
  long ts;
  int key;

  TsKey(long ts, int key){
    this.ts = ts;
    this.key = key;
  }
}
