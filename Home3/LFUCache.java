package Home3;

/**
 * Created by user on 21.01.2017.
 */
import java.util.LinkedHashMap;
import java.util.Map;

public class LFUCache {
    
    public LFUCache() {
    }

    class CacheEntry {

        private String data;
        private int frequency;

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public void setFrequency(int frequency) {
            this.frequency = frequency;
        }

    }

    private static int initialCapacity = 10;

    private static LinkedHashMap<Integer, CacheEntry> cacheMap = new LinkedHashMap<Integer, CacheEntry>();

    public void put(int key, String data)
    {
        if(!isFull())
        {
            CacheEntry tmp = new CacheEntry();
            tmp.setData(data);
            tmp.setFrequency(0);

            cacheMap.put(key, tmp);
        }
        else
        {
            int entryKeyToBeRemoved = getLFUKey();
            cacheMap.remove(entryKeyToBeRemoved);

            CacheEntry tmp = new CacheEntry();
            tmp.setData(data);
            tmp.setFrequency(0);

            cacheMap.put(key, tmp);
        }
    }

    public int getLFUKey()
    {
        int key = 0;
        int minFreq = Integer.MAX_VALUE;

        for(Map.Entry<Integer, CacheEntry> entry : cacheMap.entrySet())
        {
            if(minFreq > entry.getValue().frequency)
            {
                key = entry.getKey();
                minFreq = entry.getValue().frequency;
            }
        }

        return key;
    }

    public String get(int key)
    {
        if(cacheMap.containsKey(key))
        {
            CacheEntry tmp = cacheMap.get(key);
            tmp.frequency++;
            cacheMap.put(key, tmp);
            return tmp.data;
        }
        return null;
    }

    public static boolean isFull()
    {
        if(cacheMap.size() == initialCapacity)
            return true;

        return false;
    }

    public static void showResult(LFUCache lfu){
        System.out.println("Stack " + lfu.getLFUKey());
        System.out.println("Value " + lfu.get(1));
        System.out.println("/////////");
    }
}