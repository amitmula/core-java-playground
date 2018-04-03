package collections.map;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by amit.k.mula on 29/3/17.
 */
public class TreeMapDemo {
    private Map treeMap;

    public TreeMapDemo() {
        this.treeMap = new TreeMap();
    }

    public Map getTreeMap() {
        return this.treeMap;
    }

    public static void main(String args[]) {

        Map hashMap = new HashMap();
        hashMap.put("ghi", "789");
        hashMap.put("def", "456");
        hashMap.put("mno", "131415");
        hashMap.put("jkl", "101112");
        hashMap.put("abc","123");
        System.out.println(hashMap);

        TreeMapDemo demo = new TreeMapDemo();
        final Map treeMap = demo.getTreeMap();   //making treeMap immutable, not the data but only the reference
        treeMap.put("def", "456");
        treeMap.put("abc", "123");
        treeMap.put("jkl", "101112");
        treeMap.put("ghi", "789");
        treeMap.put("mno", "131415");
        //treeMap = demo.getTreeMap();      Can't reassign to a immutable reference, treeMap
        System.out.println(treeMap);
    }
}
