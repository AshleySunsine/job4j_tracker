package ru.job4j.collection;

import java.util.HashSet;

public class UniqueText {
    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        for (String item : origin) {
            check.add(item);
        }
         for (String itemDublicate : text) {
             if (!check.contains(itemDublicate)) {
                 rsl = false;
                 break;
             }
         }
         return rsl;
    }
}