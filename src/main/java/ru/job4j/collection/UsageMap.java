package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("Drakula@bla.blabla", "Graph");
        map.put("Da@.net", "Da");
        for (String key : map.keySet()) {
            System.out.println("key = " + key + "; value = " + map.get(key));
        }
    }
}
