package be.ecam.basics.exercises;

import java.util.Iterator;
import java.util.List;

public class ListUtils {
    public static List<String> removeShortStrings(List<String> list, int minLen) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String s = it.next();
            if (s.length() < minLen) {
                it.remove();  // suppression sécurisée via l'iterator
            }
        }
        return list;
    }
}
