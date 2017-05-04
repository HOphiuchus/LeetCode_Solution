package main;

import java.util.ArrayList;
import java.util.List;

/**
 * To be optimized
 */
public class LC038CountAndSay {
    public String countAndSay(int n) {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        for (int i = 1; i < n; i++) {
            int count = 1;
            int prev = arrayList.get(0);
            ArrayList<Integer> tmpArrayList = new ArrayList<>();
            for (int j = 1; j < arrayList.size(); j++) {
                if (arrayList.get(j) == prev) {
                    count++;
                } else {
                    tmpArrayList.add(count);
                    tmpArrayList.add(prev);
                    prev = arrayList.get(j);
                    count = 1;
                }
            }
            tmpArrayList.add(count);
            tmpArrayList.add(prev);
            arrayList = tmpArrayList;
        }
        Integer[] integers = arrayList.toArray(new Integer[0]);
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer integer : integers) {
            stringBuilder.append(integer);
        }
        return stringBuilder.toString();
    }
}
