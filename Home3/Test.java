package Home3;

import static Home3.LFUCache.showResult;

/**
 * Created by user on 21.01.2017.
 */
public class Test {

    public static void main(String[] args) {

        LFUCache lfu = new LFUCache();
        lfu.put(1, "A");
        lfu.put(1, "B");
        lfu.put(2, "C");
        lfu.put(1, "D");
        lfu.put(3, "C");
        showResult(lfu);
        lfu.put(1, "A");

        System.out.println(lfu.get(1));
        System.out.println(lfu.get(3));

    };

}